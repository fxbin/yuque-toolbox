package cn.fxbin.yuque.sdk.dto;

import cn.fxbin.yuque.sdk.enums.DocFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DocDTO
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/1 14:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocCreateDTO implements Serializable {

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
    private DocFormat format = DocFormat.markdown;

    /**
     * format 描述的正文内容，最大允许 5MB
     */
    private String body;

}
