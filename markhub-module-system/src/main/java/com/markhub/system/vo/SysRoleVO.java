package com.markhub.system.vo;

import com.bewater.markhub.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Auther: emp
 * @Date: 2024/12/31 20:45
 * @Description:
 */
@Data
@Schema(description = "角色")
public class SysRoleVO {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "角色名称")
    @NotBlank(message = "角色名称不能为空")
    private String name;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "数据范围  0：仅本人数据权限  1：全部数据权限  2：本部门数据  3：本机构及子机构数据权限  ")
    private Integer dataScope;

    @Schema(description = "菜单ID列表")
    private List<Long> menuIdList;

    @Schema(description = "机构ID列表")
    private List<Long> orgIdList;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private LocalDateTime createTime;

}
