package cn.fxbin.yuque.sdk.autoconfigure;

import cn.fxbin.yuque.sdk.properties.YuqueProperties;
import cn.fxbin.yuque.sdk.util.EnvUtils;
import net.dreamlu.mica.auto.annotation.AutoEnvPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.HashMap;
import java.util.Map;

/**
 * EnvironmentPostProcessor
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/7/31 16:24
 */
@AutoEnvPostProcessor
@EnableConfigurationProperties(YuqueProperties.class)
public class YuqueEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private final static String YUQUE_BASEURL = "yuque.base-url";

    private final static String DEFAULT_YUQUE_BASE_URL = "https://www.yuque.com/api/v2";

    private final static String FOREST_VARIABLES_YUQUEURL = "forest.variables.yuqueUrl";

    private final static Map<String, String> VARIABLES_MAP = new HashMap<>(){{
        put(YUQUE_BASEURL, FOREST_VARIABLES_YUQUEURL);
    }};

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        // 获取自定义属性
        String yuqueBaseUrl = environment.getProperty(YUQUE_BASEURL, DEFAULT_YUQUE_BASE_URL);
        EnvUtils.applyTo(VARIABLES_MAP.get(YUQUE_BASEURL), yuqueBaseUrl);
    }


}
