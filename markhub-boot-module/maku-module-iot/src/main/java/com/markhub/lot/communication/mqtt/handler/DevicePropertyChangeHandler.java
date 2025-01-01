package com.markhub.lot.communication.mqtt.handler;


import com.markhub.lot.communication.dto.DevicePropertyDTO;

/**
 * 设备属性变化处理器
 *
 * @author LSF maku_lsf@163.com
 */
public interface DevicePropertyChangeHandler {
    /**
     * 设备属性状态变化处理
     *
     * @param topic
     * @param deviceStatus
     */
    void handle(String topic, DevicePropertyDTO deviceStatus);
}
