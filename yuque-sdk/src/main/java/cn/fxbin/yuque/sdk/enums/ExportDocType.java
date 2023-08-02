package cn.fxbin.yuque.sdk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ExportDocType
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/2 14:29
 */
@Getter
@AllArgsConstructor
public enum ExportDocType {

    markdown("md"), word("docx"), pdf("pdf"), jpg("jpg");

    private final String value;

}
