package cn.fxbin.yuque.sdk.dto;

import cn.fxbin.yuque.sdk.enums.PublicScope;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RepoDTO
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/1 11:26
 */
@NoArgsConstructor
@Data
public class RepoDTO {

    /**
     * 仓库名称
     */
    private String name;

    /**
     * slug, 仓库路径
     */
    private String slug;

    /**
     * 说明
     */
    private String description;

    @JsonProperty("public")
    private PublicScope publicX;

    /**
     * ‘Book’ 文库, ‘Design’ 画板, 请注意大小写
     */
    private String type;

}
