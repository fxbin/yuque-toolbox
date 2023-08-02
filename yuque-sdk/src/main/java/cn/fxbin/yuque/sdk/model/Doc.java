package cn.fxbin.yuque.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Doc
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/7/31 14:27
 */
@NoArgsConstructor
@Data
public class Doc implements Serializable {

    /**
     * 文档编号
     */
    private Integer id;

    /**
     * 文档路径
     */
    private String slug;
    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 文档创建人 user_id
     */
    @JsonProperty("user_id")
    private String userId;

    /**
     * 状态 [1 - 正常, 0 - 草稿]
     */
    private Integer status;

    /**
     * 是否公开 [1 - 公开, 0 - 私密]
     */
    @JsonProperty("public")
    private Integer publicX;

    /**
     * 删除时间，未删除为 null
     */
    @JsonProperty("deleted_at")
    private String deletedAt;

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
