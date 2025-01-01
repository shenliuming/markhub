package com.markhub.lot.communication.mqtt.handler;


import com.markhub.lot.communication.dto.DeviceCommandResponseDTO;

/**
 * 设备命令响应处理器
 *
 * @author LSF maku_lsf@163.com
 */
public interface DeviceCommandResponseHandler {
    /**
     * 设备命令响应处理
     *
     * @param topic
     * @param commandResponse
     */
    void handle(String topic, DeviceCommandResponseDTO commandResponse);
}
