package cn.fxbin.yuque.sdk.dto;

import cn.fxbin.yuque.sdk.enums.DocFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DocUpdateDTO
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/2 11:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocUpdateDTO implements Serializable {

    /**
     * 标题
     */
    private String title;

    /**
     * 文档 Slug
     */
    private String slug;

    /**
     * 支持 markdown、lake、html，默认为 markdown
     */
    private DocFormat format = DocFormat.markdown;;

    /**
     * 已发布的正文 Markdown，这个字段必传
     */
    private String body;

    /**
     * false: 不开启 lake 自动转换   * 默认值
     * true: 开启 lake 自动转换
     * 当遇到报错提示“抱歉，语雀不允许通过 API 修改富文本格式文档，请到语雀进行操作。”，请尝试开启 lake 自动转换。
     *  (开启时 format 必须填 markdown)
     */
    @JsonProperty("_force_asl")
    private boolean forceAsl;


}
