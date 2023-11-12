package cn.fxbin.yuque.export.provider;

import cn.fxbin.yuque.sdk.YuqueApi;
import cn.fxbin.yuque.sdk.model.Toc;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.json.JSONUtil;
import jakarta.annotation.Resource;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * RepoTocProvider
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/11/11 10:31
 */
@Slf4j
@Component
public class RepoTocProvider {

    @Resource
    private YuqueApi yuqueApi;

    /**
     * getTocTreeToc
     *
     * @since 2023/11/11 12:14
     * @param namespace 命名空间
     * @return 目录树 {@link List<TocExt>}
     */
    public List<TocExt> getTocTreeToc(String namespace) {
        // 原始数据
        List<Toc> allTocList = yuqueApi.repoToc(namespace).getData();

        List<TocExt> allList = BeanUtil.copyToList(allTocList, TocExt.class);
        List<TocExt> list = allList.stream().filter(tocExt -> tocExt.getParentUuid().isBlank()).toList();

        this.buildTocTree(list, allList);

        log.info("toc list ===>>> {}", JSONUtil.toJsonStr(list));
        return list;
    }

    /**
     * getTocTreeToc
     *
     * @since 2023/11/11 12:14
     * @param repoId 仓库id
     * @return 目录树 {@link List<TocExt>}
     */
    public List<TocExt> getTocTreeToc(Integer repoId) {
        String namespace = yuqueApi.repo(String.valueOf(repoId)).getData().getNamespace();
        return this.getTocTreeToc(namespace);
    }

    /**
     * buildTocTree 构建目录树
     *
     * @since 2023/11/11 12:13
     * @param list 初始列表 {@link List<TocExt>}
     * @param allList 全部列表数据 {@link List<TocExt>}
     */
    private void buildTocTree(List<TocExt> list, List<TocExt> allList) {
        list.forEach(tocExt -> {
            List<TocExt> children = allList.stream()
                    .filter(toc -> toc.getParentUuid().equals(tocExt.getUuid()))
                    .toList();

            if (CollectionUtil.isNotEmpty(children)) {
                List<TocExt> sortedTocExtList = this.sortedTocExtList(children);
                tocExt.getChildren().addAll(sortedTocExtList);
                this.buildTocTree(sortedTocExtList, allList);
            }
        });
    }

    /**
     * 排序toc文本列表
     *
     * @param list 列表
     * @return {@link List}<{@link TocExt}>
     */
    private List<TocExt> sortedTocExtList(List<TocExt> list) {

        if (CollectionUtil.isEmpty(list)) {
            return ListUtil.empty();
        }

        Map<String, TocExt> uuidTocExtMap
                = list.stream().collect(Collectors.toMap(Toc::getUuid, obj -> obj));

        Optional<TocExt> headNodeOptional = list.stream().filter(tocExt -> tocExt.getParentUuid().isBlank()).findAny();
        Optional<TocExt> endNodeOptional = list.stream().filter(tocExt -> tocExt.getSiblingUuid().isBlank()).findAny();

        List<TocExt> sortedList = new ArrayList<>();
        // 如果头节点有值,正向寻找
        if (headNodeOptional.isPresent()) {
            TocExt headNode = headNodeOptional.get();
            sortedList.add(headNode);
            this.setDataNode(uuidTocExtMap, sortedList, headNode.getSiblingUuid(), true);
        }

        // 如果尾节点有值，则逆向寻找，最后翻转结果列表
        if (endNodeOptional.isPresent()) {
            TocExt endNode = endNodeOptional.get();
            sortedList.add(endNode);
            this.setDataNode(uuidTocExtMap, sortedList, endNode.getPrevUuid(), false);

            CollectionUtil.reverse(sortedList);
        }
        return sortedList;
    }

    /**
     * 设置数据节点
     *
     * @param uuidTocExtMap uuid-toc-ext文件夹
     * @param list          列表
     * @param uuid          uuid
     * @param isHead        是头
     */
    private void setDataNode(Map<String, TocExt> uuidTocExtMap, List<TocExt> list, String uuid, Boolean isHead) {
        while (uuidTocExtMap.containsKey(uuid)) {
            TocExt currentNode = uuidTocExtMap.get(uuid);
            list.add(currentNode);
            uuidTocExtMap.remove(uuid);
            setDataNode(uuidTocExtMap, list, isHead ? currentNode.getSiblingUuid() : currentNode.getPrevUuid(), isHead);
        }
    }


    @EqualsAndHashCode(callSuper = true)
    @Data
    @Builder
    @Accessors(chain = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString(callSuper = true)
    public static class TocExt extends Toc implements Serializable {

        private List<TocExt> children = new ArrayList<>();

    }

}