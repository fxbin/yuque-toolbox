package cn.fxbin.yuque.export.provider;

import cn.fxbin.yuque.export.config.YuqueExportProperties;
import cn.fxbin.yuque.sdk.YuqueApi;
import cn.fxbin.yuque.sdk.enums.ExportDocType;
import cn.fxbin.yuque.sdk.enums.TocType;
import cn.fxbin.yuque.sdk.model.DocDetail;
import cn.fxbin.yuque.sdk.model.RepoDetail;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DocExportProvider
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/2 14:28
 */
@Slf4j
@Component
@EnableConfigurationProperties(YuqueExportProperties.class)
public class DocExportProvider {

    @Resource
    private YuqueApi yuqueApi;

    @Resource
    private RepoTocProvider repoTocProvider;

    @Resource
    private YuqueExportProperties properties;

    private final static Map<String, String> map = new HashMap<>();

    /**
     * 导出
     *
     * @param type      类型
     * @param repoId 仓库ID
     */
    public void export(ExportDocType type, Integer repoId) {
        RepoDetail repoDetail = yuqueApi.repo(String.valueOf(repoId)).getData();
        // 仓库存储路径
        String dirPath = properties.getPath() + "/" + repoDetail.getName();
        // 创建仓库名称
        if (!FileUtil.exist(dirPath)) {
            FileUtil.mkdir(dirPath);
        }

        // 仓库目录树
        List<RepoTocProvider.TocExt> tocExtList = repoTocProvider.getTocTreeToc(repoId);
        this.export(tocExtList, repoDetail, type, dirPath);
    };

    /**
     * 导出
     *
     * @param tocExtList toc文本列表
     * @param repoDetail 回购详细信息
     * @param type       类型
     * @param dirPath    dir路径
     */
    private void export(List<RepoTocProvider.TocExt> tocExtList, RepoDetail repoDetail, ExportDocType type, String dirPath) {
        tocExtList.forEach(tocExt -> {

            if (TocType.TITLE == tocExt.getType()) {
                String tocPath = dirPath + "/" + tocExt.getTitle();
                if (!FileUtil.exist(tocPath)) {
                    FileUtil.mkdir(tocPath);
                }
                map.put(tocExt.getUuid(), tocPath);
            }

            if (TocType.DOC == tocExt.getType()) {
                DocDetail docDetail = yuqueApi.docs(repoDetail.getNamespace(), tocExt.getSlug()).getData();
                String title = docDetail.getTitle();
                String body = docDetail.getBody();

                String filePath = dirPath + "/" + title +  "." + type.getValue();
                log.info("filePath: {}", filePath);

                try {
                    FileUtil.appendUtf8String(body, filePath);
                } catch (Exception e) {
                    log.error("error: {}, filePath: {}", e.getMessage(), filePath);
                }

                // 随机休眠
                ThreadUtil.sleep(RandomUtil.randomInt(100, 1000));
            }

            if (CollectionUtil.isNotEmpty(tocExt.getChildren())) {
                log.info("path map: {}", JSONUtil.toJsonPrettyStr(map));
                this.export(tocExt.getChildren(), repoDetail, type, map.get(tocExt.getUuid()));
            }
        });
    }

}
