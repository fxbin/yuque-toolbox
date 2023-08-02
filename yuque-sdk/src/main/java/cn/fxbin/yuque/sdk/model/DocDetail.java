package cn.fxbin.yuque.sdk.model;

import cn.fxbin.yuque.sdk.enums.DocFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * DocDetail
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/1 14:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DocDetail extends Doc implements Serializable {

    /**
     * 仓库编号，就是 repo_id
     */
    @JsonProperty("book_id")
    private Integer bookId;

    /**
     * 仓库信息
     */
    @JsonProperty("book")
    private Repo repo;

    /**
     * 用户/团队信息
     */
    private User user;

    /**
     * 描述了正文的格式 [lake , markdown]
     */
    private DocFormat format;

    /**
     * 正文 Markdown 源代码
     */
    private String body;

    /**
     * 草稿 Markdown 源代码
     */
    @JsonProperty("body_draft")
    private String bodyDraft;

    /**
     * 转换过后的正文 HTML
     * <a href="https://www.yuque.com/yuque/developer/yr938f">重大变更，详情请参考</a>
     */
    @JsonProperty("body_html")
    private String bodyHtml;

    /**
     * 视图状态
     */
    @JsonProperty("view_status")
    private Integer viewStatus;

    /**
     * 读状态
     */
    @JsonProperty("read_status")
    private Integer readStatus;

    /**
     * 喜欢数
     */
    @JsonProperty("likes_count")
    private Integer likesCount;

    /**
     * 阅读数
     */
    @JsonProperty("read_count")
    private Integer readCount;

    /**
     * 评论数
     */
    @JsonProperty("comments_count")
    private Integer commentsCount;

    /**
     *  文档内容更新时间
     */
    @JsonProperty("content_updated_at")
    private String contentUpdatedAt;

    /**
     * 发布时间
     */
    @JsonProperty("published_at")
    private String publishedAt;

    /**
     * 首次发布时间
     */
    @JsonProperty("first_published_at")
    private String firstPublishedAt;

    /**
     * 草稿版本
     */
    @JsonProperty("draft_version")
    private Integer draftVersion;

    /**
     * 字数
     */
    @JsonProperty("word_count")
    private Integer wordCount;

    /**
     * 封面
     */
    private String cover;

    /**
     * 定制封面
     */
    @JsonProperty("custom_cover")
    private String customCover;

    /**
     * 自定义描述
     */
    @JsonProperty("custom_description")
    private String customDescription;


}
