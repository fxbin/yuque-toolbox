package cn.fxbin.yuque.sdk.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * UserType
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/1 11:41
 */
@Getter
@AllArgsConstructor
public enum UserType {

    //  [`User`  - 用户, Group - 团队]
    user("User"),

    group("Group");


    @JsonValue
    private final String value;

}
