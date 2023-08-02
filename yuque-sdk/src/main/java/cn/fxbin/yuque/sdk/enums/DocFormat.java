package cn.fxbin.yuque.sdk.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DocFormat
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/1 16:14
 */
@Getter
@AllArgsConstructor
public enum DocFormat {

    markdown("markdown"),

    lake("lake"),

    html("html");

    @JsonValue
    private final String value;



}
