package cn.fxbin.yuque.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * UserDetail
 * <a href="https://www.yuque.com/yuque/developer/userdetailserializer">UserDetailSerializer</a>
 *
 * @author fxbin
 * @version v1.0
 * @since 2023/8/1 11:02
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class UserDetail extends User implements Serializable {

    /**
     * 企业空间编号
     */
    @JsonProperty("space_id")
    private Integer spaceId;

    /**
     * 用户账户编号
     */
    @JsonProperty("account_id")
    private Integer accountId;

    /**
     * 粉丝数
     */
    @JsonProperty("followers_count")
    private Integer followersCount;

    /**
     * 关注数
     */
    @JsonProperty("following_count")
    private Integer followingCount;

    /**
     * 仓库数量
     */
    @JsonProperty("books_count")
    private Integer booksCount;

    /**
     * 公开仓库数量
     */
    @JsonProperty("public_books_count")
    private Integer publicBooksCount;

}
