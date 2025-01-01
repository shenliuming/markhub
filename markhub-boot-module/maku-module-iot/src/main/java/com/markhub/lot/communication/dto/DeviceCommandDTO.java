package com.markhub.lot.communication.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import com.markhub.lot.enums.DeviceCommandEnum;

/**
 * 设备命令对象
 *
 * @author LSF maku_lsf@163.com
 */
@Data
@Schema(description = "设备命令对象")
public class DeviceCommandDTO extends BaseDeviceID {
    /**
     * 命令类型
     */
    @Schema(description = "命令类型", required = true)
    private DeviceCommandEnum command;

    /**
     * 命令id
     */
    @Schema(description = "命令id", required = true)
    private String id;

    /**
     * 命令内容
     */
    @Schema(description = "命令内容")
    private String payload;
}