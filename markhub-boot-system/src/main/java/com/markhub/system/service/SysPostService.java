package com.markhub.system.service;

import com.markhub.framework.common.utils.PageResult;
import com.markhub.framework.mybatis.service.BaseService;
import com.markhub.system.entity.SysPostEntity;
import com.markhub.system.query.SysPostQuery;
import com.markhub.system.vo.SysPostVO;

import java.util.List;

/**
 * 岗位管理
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface SysPostService extends BaseService<SysPostEntity> {

    PageResult<SysPostVO> page(SysPostQuery query);

    List<SysPostVO> getList();

    List<String> getNameList(List<Long> idList);

    void save(SysPostVO vo);

    void update(SysPostVO vo);

    void delete(List<Long> idList);
}