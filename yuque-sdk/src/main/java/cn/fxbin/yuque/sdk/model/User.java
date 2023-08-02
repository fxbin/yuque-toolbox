package cn.fxbin.yuque.sdk.model;

import cn.fxbin.yuque.sdk.enums.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * User
 * <a href="https://www.yuque.com/yuque/developer/userserializer">UserSerializer</a>
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/7/31 14:22
 */
@NoArgsConstructor
@Data
public class User implements Serializable {

    /**
     * 用户编号
     */
    private Integer id;

    /**
     * 类型 [`User`  - 用户, Group - 团队]
     */
    private UserType type;

    /**
     * 用户个人路径
     */
    private String login;

    /**
     * 昵称
     */
    private String name;

    /**
     * 介绍
     */
    private String description;

    /**
     * 头像 URL
     */
    @JsonProperty("avatar_url")
    private String avatarUrl;

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
