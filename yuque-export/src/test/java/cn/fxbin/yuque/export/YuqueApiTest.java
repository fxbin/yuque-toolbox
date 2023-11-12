package cn.fxbin.yuque.export;

import cn.fxbin.yuque.export.provider.DocExportProvider;
import cn.fxbin.yuque.sdk.YuqueApi;
import cn.fxbin.yuque.sdk.enums.ExportDocType;
import cn.fxbin.yuque.sdk.model.User;
import cn.hutool.json.JSONUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * YuqueApiTest
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/7/31 14:59
 */
@Slf4j
@SpringBootTest
public class YuqueApiTest {

    @Resource
    private YuqueApi yuqueApi;

    @Resource
    private DocExportProvider docExportProvider;

    @Test
    public void getUser() {
        User user = yuqueApi.user().getData();
        log.info("user: {}", JSONUtil.toJsonPrettyStr(user));
        Assertions.assertNotNull(user);
    }

    @Test
    public void testExportMarkdown() {
        docExportProvider.export(ExportDocType.markdown, 0);
    }


}
