package com.markhub.system.query;

import com.markhub.framework.mybatis.base.query.BaseQuery;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 系统用户查询
 *
 * @Auther: emp
 * @Date: 2024/12/21 14:46
 * @Description:
 */
@Data
public class SysUserQuery extends BaseQuery {

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "性别")
    private Integer gender;

    @Schema(description = "组织机构ID")
    private List<Long> orgIds;

}
