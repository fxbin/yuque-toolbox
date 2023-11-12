package cn.fxbin.yuque.export.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * YuqueExportProperties
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/2 15:18
 */
@Data
@ConfigurationProperties(prefix = "yuque.export")
public class YuqueExportProperties {

    private String path = "/data";

}
