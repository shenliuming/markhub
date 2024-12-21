package com.markhub.system.vo;

import com.fhs.core.trans.anno.Trans;
import com.fhs.core.trans.constant.TransType;
import com.fhs.core.trans.vo.TransPojo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;


/**
 * @Auther: emp
 * @Date: 2024/12/21 16:30
 * @Description: 组织机构VO
 */
@Data
public class SysOrgVO implements Serializable, TransPojo {

    @Schema(description = "机构ID")
    private Long id;

    @Schema(description = "上级ID", required = true)
    @NotNull(message = "上级ID不能为空")
    private Long pid;

    @Schema(description = "机构名称", required = true)
    @NotBlank(message = "机构名称不能为空")
    private String name;

    @Schema(description = "排序")
    private Integer sort;

    @Schema(description = "上级名称（非数据库字段）")
    private String parentName;

    @Schema(description = "机构描述")
    private String description;

    @Schema(description = "机构状态（0: 禁用, 1: 启用）", required = true)
    @NotNull(message = "机构状态不能为空")
    private Integer status;

}