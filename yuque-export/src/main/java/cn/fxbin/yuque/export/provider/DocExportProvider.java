package cn.fxbin.yuque.export.provider;

import cn.fxbin.yuque.export.properties.YuqueExportProperties;
import cn.fxbin.yuque.sdk.YuqueApi;
import cn.fxbin.yuque.sdk.enums.ExportDocType;
import cn.fxbin.yuque.sdk.model.Doc;
import cn.fxbin.yuque.sdk.model.DocDetail;
import cn.fxbin.yuque.sdk.model.RepoDetail;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

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
    private YuqueExportProperties properties;

    /**
     * 导出
     *
     * @param type      类型
     * @param repoId 仓库ID
     */
    public void export(ExportDocType type, String repoId) {
        RepoDetail repoDetail = yuqueApi.repo(repoId).getData();

        List<Doc> docs = yuqueApi.docs(repoId).getData();


        // 仓库存储路径
        String dirPath = properties.getPath() + "/" + repoDetail.getName();
        // 创建仓库名称
        FileUtil.mkdir(dirPath);

        docs.forEach(doc -> {

            DocDetail docDetail = yuqueApi.docs(repoDetail.getNamespace(), doc.getSlug()).getData();
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
        });


    };


}
