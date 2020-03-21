package com.suancai.thymeleaf.common;

import lombok.Getter;

/**
 * @Author Bruce
 * @Date: 2020/3/20 20:49
 * @Description 结果类枚举
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(true,200,"成功"),
    UNKMON_ERROR(false, 500, "未知错误"),
    PARAM_ERROR(false, 20001,"参数错误！"),
    NPE(false, 20002,"空指针异常"),
    HTTP_CLIENT_ERROR(false, 20003,"http客户端异常");

    /**
     * 响应是否成功
     */
    private boolean success;

    /**
     * 状态响应码
     */
    private int code;

    /**
     * 响应信息
     */
    private String msg;

    ResultCodeEnum(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }
}
