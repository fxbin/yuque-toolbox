package cn.fxbin.yuque.sdk.interceptor;

import cn.fxbin.yuque.sdk.util.EnvUtils;
import cn.fxbin.yuque.sdk.util.SpringContextProvider;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.interceptor.Interceptor;
import lombok.extern.slf4j.Slf4j;

/**
 * TokenInterceptor
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/7/31 14:51
 */
@Slf4j
public class YuqueTokenInterceptor<T> implements Interceptor<T> {

    private EnvUtils envUtils = SpringContextProvider.getBean(EnvUtils.class);

    @Override
    public boolean beforeExecute(ForestRequest request) {
        log.debug("yuque-toolbox-sdk ===>>> yuque.token ==> {}", envUtils.getYuqueToken());
        request.addHeader("X-Auth-Token", envUtils.getYuqueToken());
        return true;
    }
}
