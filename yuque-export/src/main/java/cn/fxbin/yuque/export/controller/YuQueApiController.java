package cn.fxbin.yuque.export.controller;

import cn.fxbin.yuque.export.provider.DocExportProvider;
import cn.fxbin.yuque.sdk.YuqueApi;
import cn.fxbin.yuque.sdk.enums.ExportDocType;
import cn.fxbin.yuque.sdk.model.Repo;
import cn.fxbin.yuque.sdk.model.Response;
import cn.hutool.core.thread.ThreadUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * YuqueController
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/11/11 10:33
 */
@Tag(name = "语雀接口")
@RestController
@RequestMapping("/yuque")
public class YuQueApiController {

    @Resource
    private YuqueApi yuqueApi;

    @Resource
    private DocExportProvider docExportProvider;

    @Operation(summary = "仓库列表")
    @GetMapping("/listRepos")
    public Response<List<Repo>> listRepos() {
        return yuqueApi.userRepos(yuqueApi.user().getData().getId());
    }

    @Operation(summary = "根据仓库ID导出对应仓库文档")
    @Parameter(name = "repoId", description = "仓库ID", required = true)
    @PostMapping("/export/{repoId}")
    public void exportByRepoId(@PathVariable("repoId") Integer repoId) {
        ThreadUtil.execute(() -> docExportProvider.export(ExportDocType.markdown, repoId));
    }

    @Operation(summary = "导出用户全部仓库文档")
    @PostMapping("/export/all")
    public void export() {
        List<Repo> repos = yuqueApi.userRepos(yuqueApi.user().getData().getId()).getData();
        repos.forEach(repo -> ThreadUtil.execute(() -> docExportProvider.export(ExportDocType.markdown, repo.getId())));
    }
}