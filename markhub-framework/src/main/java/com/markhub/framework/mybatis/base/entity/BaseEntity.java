package com.markhub.framework.mybatis.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fhs.core.trans.vo.TransPojo;
import lombok.Data;

import java.time.LocalDateTime;


/**
 * @Auther: emp
 * @Date: 2024/12/12 15:06
 * @Description: 基类实体，提供通用字段和方法
 */
@Data
public abstract class BaseEntity extends Model<BaseEntity> implements TransPojo {

    /**
     * 主键ID.
     */
    @TableId
    private Long id;

    /**
     * 创建者ID.
     */
    @TableField(fill = FieldFill.INSERT)
    private Long creator;

    /**
     * 创建时间.
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新者ID.
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updater;

    /**
     * 更新时间.
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 乐观锁版本号.
     */
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    /**
     * 软删除标记（0=未删除，1=已删除）.
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;
}
