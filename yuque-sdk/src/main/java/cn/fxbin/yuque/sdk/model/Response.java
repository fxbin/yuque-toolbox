package cn.fxbin.yuque.sdk.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Response
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/7/31 17:12
 */
@NoArgsConstructor
@Data
public class Response <T> implements Serializable {

    private T data;

}
