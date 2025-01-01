package com.markhub.system.service;

import com.markhub.framework.common.utils.PageResult;
import com.markhub.framework.mybatis.service.BaseService;
import com.markhub.system.entity.SysDictTypeEntity;
import com.markhub.system.query.SysDictTypeQuery;
import com.markhub.system.vo.SysDictTypeVO;
import com.markhub.system.vo.SysDictVO;

import java.util.List;

/**
 * 数据字典
 *
 * @author 阿沐 babamu@126.com
 * <a href="https://maku.net">MAKU</a>
 */
public interface SysDictTypeService extends BaseService<SysDictTypeEntity> {

    PageResult<SysDictTypeVO> page(SysDictTypeQuery query);

    List<SysDictTypeVO> list(Long pid);

    void save(SysDictTypeVO vo);

    void update(SysDictTypeVO vo);

    void delete(List<Long> idList);

    /**
     * 获取动态SQL数据
     */
    List<SysDictVO.DictData> getDictSql(Long id);

    /**
     * 获取全部字典列表
     */
    List<SysDictVO> getDictList();

    /**
     * 刷新字典缓存
     */
    void refreshTransCache();

}