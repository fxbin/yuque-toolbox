package cn.fxbin.yuque.sdk;

import cn.fxbin.yuque.sdk.dto.DocCreateDTO;
import cn.fxbin.yuque.sdk.dto.DocUpdateDTO;
import cn.fxbin.yuque.sdk.dto.RepoDTO;
import cn.fxbin.yuque.sdk.interceptor.YuqueTokenInterceptor;
import cn.fxbin.yuque.sdk.model.*;
import com.dtflys.forest.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * YuqueApi
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/7/31 14:28
 */
@BaseRequest(baseURL = "${yuqueUrl}", interceptor = YuqueTokenInterceptor.class)
public interface YuqueApi {

    /**
     * 获取认证的用户的个人信息
     * <a href="https://www.yuque.com/yuque/developer/user">User - 用户</a>
     *
     * @return {@link Response}<{@link User}>
     */
    @Get("/user")
    Response<User> user();

    /**
     * 获取单个用户信息
     * <a href="https://www.yuque.com/yuque/developer/user">User - 用户</a>
     *
     * @param id id
     * @return {@link Response}<{@link User}>
     */
    @Get("/user/{id}")
    Response<User> user(String id);


    // ======  Repo-知识库  ======


    /**
     * 获取某个用户的知识库列表
     * <a href="https://www.yuque.com/yuque/developer/repo">Repo - 知识库</a>
     *
     * @param userId 用户id
     * @return {@link Response}<{@link List}<{@link Repo}>>
     */
    @Get("/users/{userId}/repos")
    Response<List<Repo>> userRepos(@Var("userId") Integer userId);

    /**
     * 获取某个用户的知识库列表
     * <a href="https://www.yuque.com/yuque/developer/repo">Repo - 知识库</a>
     *
     * @param userId 用户id
     * @param type   Book, Design, all - 所有类型
     * @param offset 用于分页，效果类似 MySQL 的 limit offset，一页 20 条
     * @return {@link Response}<{@link List}<{@link Repo}>>
     */
    @Get("/users/{userId}/repos")
    Response<List<Repo>> userRepos(@Var("userId") String userId, @Query("type") String type,
                             @Query("offset") Integer offset);

    /**
     * 创建知识库, 往自己下面创建知识库
     * <a href="https://www.yuque.com/yuque/developer/repo">Repo - 知识库</a>
     *
     * @param userId  用户id
     * @param repoDTO {@link RepoDTO}
     * @return {@link Response}<{@link RepoDetail}>
     */
    @Post("/users/{userId}/repos")
    Response<RepoDetail> userRepos(@Var("userId") String userId, @JSONBody RepoDTO repoDTO);

    /**
     * 获取知识库详情
     * <a href="https://www.yuque.com/yuque/developer/repo">Repo - 知识库</a>
     * <p>
     *     GET /repos/:namespace
     *     # 或
     *     GET /repos/:id
     * </p>
     *
     * @param id id
     * @return {@link Response}<{@link RepoDetail}>
     */
    @Get("/repos/{id}")
    Response<RepoDetail> repo(@Var("id") String id);

    /**
     * 更新知识库信息
     * <b>需要 Repo 的 abilities.update 权限</b>
     * <a href="https://www.yuque.com/yuque/developer/repo">Repo - 知识库</a>
     *
     * @param id      id
     * @param repoDTO {@link RepoDTO}
     * @return {@link Response}<{@link RepoDetail}>
     */
    @Put("/repos/{id}")
    Response<RepoDetail> repo(@Var("id") String id, @JSONBody RepoDTO repoDTO);

    /**
     * 删除知识库
     * <a href="https://www.yuque.com/yuque/developer/repo">Repo - 知识库</a>
     *
     * @param id id
     * @return {@link Response}<{@link RepoDetail}>
     */
    @Delete("/repos/{id}")
    Response<RepoDetail> repoDel(@Var("id") String id);


    // ======  Doc-文档  ======


    /**
     * 获取一个仓库的文档列表
     * <a href="https://www.yuque.com/yuque/developer/doc">Doc - 文档</a>
     *
     * @param repoId 仓库id
     * @return {@link Response}<{@link List}<{@link Doc}>>
     */
    @Get("/repos/{id}/docs")
    Response<List<Doc>> docs(@Var("id") String repoId);

    /**
     * 获取一个仓库的文档列表
     * <a href="https://www.yuque.com/yuque/developer/doc">Doc - 文档</a>
     *
     * @param repoId 仓库id
     * @param map    其它参数，支持传递 offset / limit 进行分页获取。
     *               支持传递 optional_properties=hits 获取文档浏览数。
     *               ex: offset=0, limit=5, optional_properties=hits
     * @return {@link Response}<{@link List}<{@link Doc}>>
     */
    @Get("/repos/{id}/docs")
    Response<List<Doc>> docs(@Var("id") String repoId, @Query Map<String, Object> map);

    /**
     * 获取单篇文档的详细信息
     * <a href="https://www.yuque.com/yuque/developer/doc">Doc - 文档</a>
     *
     * @param namespace 命名空间
     * @param slug      文档路径
     * @return {@link Response}<{@link DocDetail}>
     */
    @Get("/repos/{namespace}/docs/{slug}")
    Response<DocDetail> docs(@Var("namespace") String namespace, @Var("slug") String slug);

    /**
     * 创建文档
     * <a href="https://www.yuque.com/yuque/developer/doc">Doc - 文档</a>
     *
     * @param namespace 命名空间
     * @param docCreateDTO {@link DocCreateDTO}
     * @return {@link Response}<{@link DocDetail}>
     */
    @Post("/repos/{namespace}/docs")
    Response<DocDetail> docs(@Var("namespace") String namespace, @JSONBody DocCreateDTO docCreateDTO);

    /**
     * 更新文档
     * <a href="https://www.yuque.com/yuque/developer/doc">Doc - 文档</a>
     *
     * @param namespace    命名空间
     * @param id           文档id
     * @param docUpdateDTO {@link DocUpdateDTO}
     * @return {@link Response}<{@link DocDetail}>
     */
    @Put("/repos/{namespace}/docs/{id}")
    Response<DocDetail> docs(@Var("namespace")String namespace, @Var("id") String id,
                             @JSONBody DocUpdateDTO docUpdateDTO);

    /**
     * 文档删除
     * <a href="https://www.yuque.com/yuque/developer/doc">Doc - 文档</a>
     *
     * @param namespace 命名空间
     * @param id        id
     * @return {@link Response}<{@link DocDetail}>
     */
    @Delete("/repos/{namespace}/docs/{id}")
    Response<DocDetail> docsDel(@Var("namespace")String namespace, @Var("id") String id);

}
