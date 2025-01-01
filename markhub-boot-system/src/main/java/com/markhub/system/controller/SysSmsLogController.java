package com.markhub.system.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.markhub.framework.common.utils.PageResult;
import com.markhub.framework.common.utils.Result;
import com.markhub.system.convert.SysSmsLogConvert;
import com.markhub.system.entity.SysSmsLogEntity;
import com.markhub.system.query.SysSmsLogQuery;
import com.markhub.system.service.SysSmsLogService;
import com.markhub.system.vo.SysSmsLogVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信日志
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
@RestController
@RequestMapping("sys/sms/log")
@Tag(name = "短信日志")
@AllArgsConstructor
public class SysSmsLogController {
    private final SysSmsLogService sysSmsLogService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('sys:sms:log')")
    public Result<PageResult<SysSmsLogVO>> page(@ParameterObject @Valid SysSmsLogQuery query) {
        PageResult<SysSmsLogVO> page = sysSmsLogService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('sys:sms:log')")
    public Result<SysSmsLogVO> get(@PathVariable("id") Long id) {
        SysSmsLogEntity entity = sysSmsLogService.getById(id);

        return Result.ok(SysSmsLogConvert.INSTANCE.convert(entity));
    }

}