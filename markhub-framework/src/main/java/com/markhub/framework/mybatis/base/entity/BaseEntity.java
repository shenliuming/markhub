package com.markhub.framework.mybatis.base.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fhs.core.trans.vo.TransPojo;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.time.LocalDateTime;


/**
 * @Auther: emp
 * @Date: 2024/12/12 15:06
 * @Description: 基类实体，提供通用字段和方法 DO (Data Object)
 */
@Data
@JsonIgnoreProperties(value = "transMap")
public abstract class BaseEntity extends Model<BaseEntity> implements TransPojo {

    /**
     * 创建者ID. 使用 String 类型的原因是，未来可能会存在非数值的情况，留好拓展性。适应变化能力很重要
     */
    @TableField(fill = FieldFill.INSERT, jdbcType = JdbcType.VARCHAR)
    private String creator;

    /**
     * 创建时间.
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新者ID. 使用 String 类型的原因是，未来可能会存在非数值的情况，留好拓展性。适应变化能力很重要
     */
    @TableField(fill = FieldFill.INSERT_UPDATE, jdbcType = JdbcType.VARCHAR)
    private String updater;

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
