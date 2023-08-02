package cn.fxbin.yuque.sdk.model;

import cn.fxbin.yuque.sdk.enums.RepoType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Repo
 * <a href="https://www.yuque.com/yuque/developer/bookserializer">BookDetailSerializer</a>
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/7/31 18:19
 */
@Data
public class Repo implements Serializable {

    /**
     * 仓库编号
     */
    private Integer id;

    /**
     * 类型 [Book - 文档]
     */
    private RepoType type;

    /**
     * 名字
     */
    private String name;

    /**
     * 仓库路径
     */
    private String slug;

    /**
     * 仓库完整路径 user.login/book.slug
     */
    private String namespace;

    /**
     * 所属的团队/用户编号
     */
    @JsonProperty("user_id")
    private String userId;

    /**
     * 用户信息
     */
    private User user;

    /**
     * 介绍
     */
    private String description;

    /**
     * 创建人 User Id
     */
    @JsonProperty("creator_id")
    private String creatorId;

    /**
     * 公开状态 [1 - 公开, 0 - 私密]
     */
    @JsonProperty("public")
    private String publicX;

    /**
     * 喜欢数量
     */
    @JsonProperty("likes_count")
    private Integer likesCount;

    /**
     * 订阅数量
     */
    @JsonProperty("watches_count")
    private Integer watchesCount;

    /**
     * 创建时间
     */
    @JsonProperty("created_at")
    private String createdAt;

    /**
     * 更新时间
     */
    @JsonProperty("updated_at")
    private String updatedAt;

}
