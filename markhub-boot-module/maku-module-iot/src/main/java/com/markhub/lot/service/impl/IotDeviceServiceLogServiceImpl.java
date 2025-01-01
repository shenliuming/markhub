package com.markhub.lot.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import com.markhub.framework.common.utils.JsonUtils;
import com.markhub.framework.common.utils.PageResult;
import com.markhub.framework.mybatis.service.impl.BaseServiceImpl;
import com.markhub.lot.convert.IotDeviceServiceLogConvert;
import com.markhub.lot.dao.IotDeviceServiceLogDao;
import com.markhub.lot.entity.IotDeviceServiceLogEntity;
import com.markhub.lot.enums.DeviceCommandEnum;
import com.markhub.lot.query.IotDeviceServiceLogQuery;
import com.markhub.lot.service.IotDeviceServiceLogService;
import com.markhub.lot.vo.IotDeviceServiceLogVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 设备服务日志
 *
 * @author LSF maku_lsf@163.com
 */
@Service
@AllArgsConstructor
public class IotDeviceServiceLogServiceImpl extends BaseServiceImpl<IotDeviceServiceLogDao, IotDeviceServiceLogEntity> implements IotDeviceServiceLogService {

    @Override
    public PageResult<IotDeviceServiceLogVO> page(IotDeviceServiceLogQuery query) {
        IPage<IotDeviceServiceLogEntity> page = baseMapper.selectPage(getPage(query), getWrapper(query));
        List<IotDeviceServiceLogVO> vos = IotDeviceServiceLogConvert.INSTANCE.convertList(page.getRecords());
        vos.forEach(vo -> {
            vo.setDeviceCommandEnum(DeviceCommandEnum.getEnum(vo.getServiceType()));
        });
        return new PageResult<>(vos, page.getTotal());
    }

    private LambdaQueryWrapper<IotDeviceServiceLogEntity> getWrapper(IotDeviceServiceLogQuery query) {
        LambdaQueryWrapper<IotDeviceServiceLogEntity> wrapper = Wrappers.lambdaQuery();
        if (StrUtil.isNotBlank(query.getDeviceCommandEnum())) {
            wrapper.eq(IotDeviceServiceLogEntity::getServiceType, DeviceCommandEnum.parse(query.getDeviceCommandEnum()).getValue());
        }
        wrapper.eq(query.getDeviceId() != null, IotDeviceServiceLogEntity::getDeviceId, query.getDeviceId());
        wrapper.orderByDesc(IotDeviceServiceLogEntity::getServiceTime);
        return wrapper;
    }

    @Override
    public void save(IotDeviceServiceLogVO vo) {
        IotDeviceServiceLogEntity entity = IotDeviceServiceLogConvert.INSTANCE.convert(vo);

        baseMapper.insert(entity);
    }

    @Override
    public void update(IotDeviceServiceLogVO vo) {
        IotDeviceServiceLogEntity entity = IotDeviceServiceLogConvert.INSTANCE.convert(vo);

        updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> idList) {
        removeByIds(idList);
    }

    @Override
    public IotDeviceServiceLogEntity createDeviceServiceLog(Long deviceId, Long tenantId, DeviceCommandEnum serviceCommand, String eventUid, Object payload) {
        IotDeviceServiceLogEntity deviceServiceLog = new IotDeviceServiceLogEntity();
        deviceServiceLog.setDeviceId(deviceId);
        deviceServiceLog.setTenantId(tenantId);
        deviceServiceLog.setServiceType(serviceCommand.getValue());
        deviceServiceLog.setServiceUid(eventUid);
        if (payload != null) {
            deviceServiceLog.setServicePayload((payload instanceof String)
                    ? (String) payload
                    : JsonUtils.toJsonString(payload));
        }
        deviceServiceLog.setServiceTime(LocalDateTime.now());
        return deviceServiceLog;
    }

    @Override
    public void createAndSaveDeviceServiceLog(Long deviceId, Long tenantId, DeviceCommandEnum serviceCommand, String eventUid, Object payload) {
        save(createDeviceServiceLog(deviceId, tenantId, serviceCommand, eventUid, payload));
    }

}