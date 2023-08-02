package cn.fxbin.yuque.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * RepoDetail
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/1 10:56
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class RepoDetail extends Repo implements Serializable {

    /**
     * toc
     */
    private String toc;

    /**
     * 目录原文
     */
    @JsonProperty("toc_yml")
    private String tocYml;

    /**
     * 文档数量
     */
    @JsonProperty("items_count")
    private Integer itemsCount;

}
