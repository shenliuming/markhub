package com.markhub.system.controller;

import com.markhub.framework.mybatis.base.page.PageResult;
import com.markhub.framework.util.Result;
import com.markhub.system.convert.SysUserConvert;
import com.markhub.system.entity.SysUserEntity;
import com.markhub.system.query.SysUserQuery;
import com.markhub.system.service.SysUserService;
import com.markhub.system.vo.SysUserVO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: emp
 * @Date: 2024/12/31 20:22
 * @Description:
 */
@RestController
@RequestMapping("sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("page")
    @Operation(summary = "用户分页")
    @PreAuthorize("hasAuthority('sys:user:page')")
    public Result<PageResult<SysUserVO>> page(@ParameterObject @Valid SysUserQuery query) {
        PageResult<SysUserVO> page = sysUserService.page(query);

        return Result.ok(page);
    }

//    @GetMapping("{id}")
//    @Operation(summary = "信息")
//    @PreAuthorize("hasAuthority('sys:user:info')")
//    public Result<SysUserVO> get(@PathVariable("id") Long id) {
//        SysUserVO vo = sysUserService.getById(id);
//
//        // 用户角色列表
//        List<Long> roleIdList = sysUserRoleService.getRoleIdList(id);
//        vo.setRoleIdList(roleIdList);
//
//        return Result.ok(vo);
//    }
}
