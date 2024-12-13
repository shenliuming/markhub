package com.markhub.framework.mybatis.interceptor;

import com.baomidou.mybatisplus.extension.plugins.handler.DataPermissionHandler;
import net.sf.jsqlparser.expression.Expression;

/**
 * @Auther: emp
 * @Date: 2024/12/13 20:35
 * @Description:
 */
public class DataScopeInterceptor implements DataPermissionHandler {

    @Override
    public Expression getSqlSegment(Expression where, String mappedStatementId) {
        return null;
    }


}
