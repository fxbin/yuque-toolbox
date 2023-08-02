package cn.fxbin.yuque.sdk.autoconfigure;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.context.annotation.Configuration;

/**
 * YuqueAutoConfiguration
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/1 10:19
 */
@ForestScan("cn.fxbin.yuque.sdk")
@Configuration(
        proxyBeanMethods = false
)
public class YuqueAutoConfiguration {
}
