package com.markhub.system.service;

import com.markhub.framework.common.utils.PageResult;
import com.markhub.framework.mybatis.service.BaseService;
import com.markhub.system.entity.SysLogOperateEntity;
import com.markhub.system.query.SysLogOperateQuery;
import com.markhub.system.vo.SysLogOperateVO;

/**
 * 操作日志
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface SysLogOperateService extends BaseService<SysLogOperateEntity> {

    PageResult<SysLogOperateVO> page(SysLogOperateQuery query);
}