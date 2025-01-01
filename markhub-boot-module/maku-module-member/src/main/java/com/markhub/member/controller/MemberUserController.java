package com.markhub.member.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.markhub.framework.common.utils.PageResult;
import com.markhub.framework.common.utils.Result;
import com.markhub.member.convert.MemberUserConvert;
import com.markhub.member.entity.MemberUserEntity;
import com.markhub.member.query.MemberUserQuery;
import com.markhub.member.service.MemberUserService;
import com.markhub.member.vo.MemberUserVO;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员管理
 *
 * @author 阿沐 babamu@126.com
 */
@RestController
@RequestMapping("member/user")
@Tag(name = "会员管理")
@AllArgsConstructor
public class MemberUserController {
    private final MemberUserService memberUserService;

    @GetMapping("page")
    @Operation(summary = "分页")
    @PreAuthorize("hasAuthority('member:user:all')")
    public Result<PageResult<MemberUserVO>> page(@ParameterObject @Valid MemberUserQuery query) {
        PageResult<MemberUserVO> page = memberUserService.page(query);

        return Result.ok(page);
    }

    @GetMapping("{id}")
    @Operation(summary = "信息")
    @PreAuthorize("hasAuthority('member:user:all')")
    public Result<MemberUserVO> get(@PathVariable("id") Long id) {
        MemberUserEntity entity = memberUserService.getById(id);

        return Result.ok(MemberUserConvert.INSTANCE.convert(entity));
    }

    @PostMapping
    @Operation(summary = "保存")
    @PreAuthorize("hasAuthority('member:user:all')")
    public Result<String> save(@RequestBody MemberUserVO vo) {
        memberUserService.save(vo);

        return Result.ok();
    }

    @PutMapping
    @Operation(summary = "修改")
    @PreAuthorize("hasAuthority('member:user:all')")
    public Result<String> update(@RequestBody @Valid MemberUserVO vo) {
        memberUserService.update(vo);

        return Result.ok();
    }

    @DeleteMapping
    @Operation(summary = "删除")
    @PreAuthorize("hasAuthority('member:user:all')")
    public Result<String> delete(@RequestBody List<Long> idList) {
        memberUserService.delete(idList);

        return Result.ok();
    }
}