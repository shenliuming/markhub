package com.markhub.framework.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.markhub.framework.mybatis.base.entity.BaseEntity;
import com.markhub.framework.util.FrameworkUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Auther: emp
 * @Date: 2024/12/12 17:34
 * @Description: 通用字段自动填充处理器
 */
public class UniversalMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (Objects.nonNull(metaObject) && metaObject.getOriginalObject() instanceof BaseEntity) {
            BaseEntity baseEntity = (BaseEntity) metaObject.getOriginalObject();
            LocalDateTime current = LocalDateTime.now();

            // 如果创建时间为空，使用当前时间填充
            if (Objects.isNull(baseEntity.getCreateTime())) {
                baseEntity.setCreateTime(current);
            }

            // 如果更新时间为空，使用当前时间填充
            if (Objects.isNull(baseEntity.getUpdateTime())) {
                baseEntity.setUpdateTime(current);
            }

            Long userId = FrameworkUtils.getLoginUserId();

            // 如果用户已登录且创建人为空，设置为当前登录用户
            if (Objects.nonNull(userId)) {
                if (Objects.isNull(baseEntity.getCreator())) {
                    baseEntity.setCreator(userId.toString());
                }
                if (Objects.isNull(baseEntity.getUpdater())) {
                    baseEntity.setUpdater(userId.toString());
                }
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Long userId = FrameworkUtils.getLoginUserId();

        // 更新时间为空，填充为当前时间
        if (Objects.isNull(getFieldValByName("updateTime", metaObject))) {
            setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }

        // 如果当前登录用户不为空，且更新人为空，则填充为当前登录用户
        if (Objects.nonNull(userId) && Objects.isNull(getFieldValByName("updater", metaObject))) {
            setFieldValByName("updater", userId.toString(), metaObject);
        }
    }
}
