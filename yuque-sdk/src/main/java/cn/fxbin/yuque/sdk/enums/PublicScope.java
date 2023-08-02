package cn.fxbin.yuque.sdk.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * PublicScope
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/1 11:32
 */
@Getter
@AllArgsConstructor
public enum PublicScope {

    // 0 私密
    // 1 所有人可见
    // 2 空间成员可见

    privacy(0),

    user_visible(1),

    group_visible(2);

    @JsonValue
    private final int value;


}
