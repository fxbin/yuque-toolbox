package cn.fxbin.yuque.sdk.model;

import cn.fxbin.yuque.sdk.enums.TocType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Toc
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/11/11 10:16
 */
@NoArgsConstructor
@Data
public class Toc implements Serializable {

    /**
     * 节点id
     */
    private Integer id;

    /**
     * 节点类型
     */
    private TocType type;

    /**
     * 节点名称
     */
    private String title;

    /**
     * 节点唯一 id
     */
    private String uuid;

    /**
     * 链接或文档 slug
     */
    private String url;


    /**
     * 上一个节点uuid
     */
    @JsonProperty("prev_uuid")
    private String prevUuid;

    /**
     * 下一个节点uuid
     */
    @JsonProperty("sibling_uuid")
    private String siblingUuid;

    /**
     * 第一个子节点uuid
     */
    @JsonProperty("child_uuid")
    private String childUuid;

    /**
     * 父节点uuid
     */
    @JsonProperty("parent_uuid")
    private String parentUuid;

    /**
     * 仅文档类型节点
     */
    @JsonProperty("doc_id")
    private Integer docId;

    /**
     * 节点层级
     */
    private Integer level;

    /**
     * 链接是否在新窗口打开，0 在当前页面打开，1 在新窗口打开
     */
    @JsonProperty("open_window")
    private Integer openWindow;

    /**
     * 节点是否可见，0 不可见，1 可见
     */
    private Integer visible;

    /**
     * 目录深度
     */
    private Integer depth;

    /**
     * 文档 slug, 目录为 #
     */
    private String slug;
}