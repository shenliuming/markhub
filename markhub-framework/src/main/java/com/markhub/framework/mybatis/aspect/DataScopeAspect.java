package com.markhub.framework.mybatis.aspect;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.markhub.framework.mybatis.annotation.DataScope;
import com.markhub.framework.mybatis.enums.DataScopeLevel;
import com.markhub.framework.security.auth.AuthUser;
import com.markhub.framework.util.FrameworkUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: emp
 * @Date: 2024/12/17 21:26
 * @Description:
 */
@Aspect
@Component
public class DataScopeAspect {

    @Pointcut("@annotation(com.markhub.framework.mybatis.annotation.DataScope)") // 匹配带 @DataScope 注解的方法
    public void dataScopePointcut() {}

    @Before("dataScopePointcut() && @annotation(dataScope)") // 拦截带注解的方法
    public void beforeExecute(JoinPoint joinPoint, DataScope dataScope) {
        // 获取注解上的参数
        String tableAlias = dataScope.tableAlias();
        String orgIdAlias = dataScope.orgIdAlias();

        // 获取当前登录的用户信息
        AuthUser user = FrameworkUtils.getLoginUser();
        // 超管默认拥有所有数据权限
        if (user.getIsSuperAdmin().equals(DataScopeLevel.ALL.getScope())) {
            return;
        }
        // 获取数据权限 SQL
        String sqlFilter = getSqlFilter(user, tableAlias, orgIdAlias);
        // 注入到 LambdaQueryWrapper
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof LambdaQueryWrapper) {
                @SuppressWarnings("unchecked")
                LambdaQueryWrapper<Object> queryWrapper = (LambdaQueryWrapper<Object>) arg;
                queryWrapper.apply(sqlFilter); // 添加数据权限条件
            }
        }
    }

    /**
     * 生成数据权限的 SQL 过滤条件
     */
    private String getSqlFilter(AuthUser user, String tableAlias, String orgIdAlias) {
        // 如果为 null，则设置为空字符串
        if (tableAlias == null) {
            tableAlias = "";
        }
        // 获取表的别名
        if (StrUtil.isNotBlank(tableAlias)) {
            tableAlias += ".";
        }
        StringBuilder sqlFilter = new StringBuilder();
        sqlFilter.append(" (");
        // 用户的数据访问范围
        List<Long> dataScopeList = user.getUserDataAccessScope();
        if (dataScopeList == null) {
            return "1=0"; // 无权限访问
        }
        // 机构的过滤
        if (dataScopeList.size() > 0) {
            sqlFilter.append(tableAlias).append(orgIdAlias);
            sqlFilter.append(" in(").append(StrUtil.join(",", dataScopeList)).append(")");
            sqlFilter.append(" or ");
        }
        // 过滤本人数据
        sqlFilter.append(tableAlias).append("creator").append("=").append(user.getId());
        sqlFilter.append(")");
        return sqlFilter.toString();
    }

}
