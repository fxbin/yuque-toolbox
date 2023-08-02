package cn.fxbin.yuque.sdk.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * YuQueProperties
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/7/31 14:33
 */
@Data
@ConfigurationProperties(prefix = "yuque")
public class YuqueProperties {

    /**
     * 语雀 baseUrl, 默认为：<a href="https://www.yuque.com/api/v2">https://www.yuque.com/api/v2</a>
     */
    private String baseUrl;

    /**
     * 语雀 Token
     */
    private String token;

}
