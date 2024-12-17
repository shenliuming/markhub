package com.markhub.framework.mybatis.base.query;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * @Auther: emp
 * @Date: 2024/12/17 22:07
 * @Description: 基础分页
 */
@Data
public class BaseQuery {

    /**
     * 当前页码，表示分页查询的起始页
     */
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码最小值为 1")
    @Schema(description = "当前页码，表示分页查询的起始页", required = true)
    Integer pageNo;

    /**
     * 每页显示的记录条数，控制每次查询的数据量
     */
    @NotNull(message = "每页条数不能为空")
    @Range(min = 1, max = 1000, message = "每页条数，取值范围 1-1000")
    @Schema(description = "每页显示的记录条数，控制每次查询的数据量", required = true)
    Integer pageSize;

    /**
     * 排序字段，指定排序的列名
     */
    @Schema(description = "排序字段，指定排序的列名")
    String sortBy;

    /**
     * 是否按升序排列，默认为降序排序
     */
    @Schema(description = "是否按升序排列，默认为降序排序")
    boolean asc;

}
