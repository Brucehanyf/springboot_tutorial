package com.suancai.thymeleaf.common;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Bruce
 * @Date: 2020/3/20 20:56
 * @Description 通用返回类
 */
@Data
public class CommonResponse {

    /**
     * 是否成功
      */
    private boolean success;

    /**
     * 响应码
     */
    private int code;

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Map<String, Object> data = new HashMap<>();

    private CommonResponse(){}

    /**
     * 通用返回成功
     * @return
     */
    public static CommonResponse ok(){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(ResultCodeEnum.SUCCESS.isSuccess());
        commonResponse.setCode(ResultCodeEnum.SUCCESS.getCode());
        commonResponse.setMsg(ResultCodeEnum.SUCCESS.getMsg());
        return commonResponse;
    }

    /**
     * 通用返回未知错误
     * @return
     */
    public static CommonResponse error(){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(ResultCodeEnum.UNKMON_ERROR.isSuccess());
        commonResponse.setCode(ResultCodeEnum.UNKMON_ERROR.getCode());
        commonResponse.setMsg(ResultCodeEnum.UNKMON_ERROR.getMsg());
        return commonResponse;
    }

    /**
     * 设置结果
     */
    public static CommonResponse setResult(ResultCodeEnum result) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setSuccess(result.isSuccess());
        commonResponse.setCode(result.getCode());
        commonResponse.setMsg(result.getMsg());
        return commonResponse;
    }

    /**
     * 设置数据
     * @param data
     * @return
     */
    public CommonResponse data(Map<String, Object> data){
        this.setData(data);
        return this;
    }

    /***
     * 自定义data
     * @param key
     * @param value
     * @return
     */
    public CommonResponse data(String key, String value){
        this.data.put(key, value);
        return this;
    }

    /**
     * 自定义报错信息
     * @param message
     * @return
     */
    public CommonResponse msg(String message) {
        this.setMsg(message);
        return this;
    }

    /**
     * 自定义状态码
      * @param code
     * @return
     */
    public CommonResponse code(int code) {
        this.setCode(code);
        return this;
    }

    /**
     * 自定义返回结果
     * @param result
     * @return
     */
    public CommonResponse result(boolean result) {
        this.setSuccess(result);
        return this;
    }
}
