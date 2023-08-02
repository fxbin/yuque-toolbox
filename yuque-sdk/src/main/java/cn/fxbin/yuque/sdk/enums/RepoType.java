package cn.fxbin.yuque.sdk.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * RepoType
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/1 11:28
 */
@Getter
@AllArgsConstructor
public enum RepoType {

    /**
     * 文库
     */
    book("Book"),

    /**
     * 画板
     */
    design("Design");


    @JsonValue
    private final String value;



}
