package com.markhub.framework.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: emp
 * @Date: 2024/12/31 20:27
 * @Description:
 */
@Data
@Schema(description = "统一响应")
public class Result<T> {

    @Schema(description = "200 表示成功")
    private int code = 200;

    @Schema(description = "消息内容")
    private String msg = "success";

    @Schema(description = "追踪ID")
    private String traceId;

    @Schema(description = "服务时间")
    private Date serverTime;

    @Schema(description = "响应数据")
    private T data;

    public static <T> Result<T> ok() {
        return ok(null);
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setData(null);
        return result;
    }

    public static <T> Result<T> error(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(null);
        return result;
    }

    public static <T> Result<T> error(int code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        return result;
    }

}
