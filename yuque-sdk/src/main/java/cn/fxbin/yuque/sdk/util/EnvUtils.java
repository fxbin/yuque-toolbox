package cn.fxbin.yuque.sdk.util;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Properties;

/**
 * EnvUtils
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/7/31 17:01
 */
@Component
public class EnvUtils implements EnvironmentAware {

    public static final String YUQUE_TOKEN = "yuque.token";


    /**
     * applicationContext config environment
     * Affected by "spring.profiles.active" config properties
     * {@link EnvironmentAware}
     */
    @Nullable
    private Environment environment;


    /**
     * 获取yuque令牌
     *
     * @return {@link String}
     */
    public String getYuqueToken() {
        return environment.getProperty(YUQUE_TOKEN);
    }

    /**
     * applyTo
     * 配置系统属性
     *
     * @param key   关键
     * @param value 值
     */
    public static void applyTo(String key, String value) {
        put(System.getProperties(), key, value);
        put(System.getProperties(), key, value);
    }

    private static void put(Properties properties, String key, String value) {
        if (StringUtils.hasText(value)) {
            properties.put(key, value);
        }
    }

    /**
     * Set the {@code Environment} that this component runs in.
     *
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
