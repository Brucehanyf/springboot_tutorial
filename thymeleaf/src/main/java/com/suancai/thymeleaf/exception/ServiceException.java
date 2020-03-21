package com.suancai.thymeleaf.exception;

import com.suancai.thymeleaf.common.ResultCodeEnum;
import lombok.Data;

/**
 * @Author Bruce
 * @Date: 2020/3/20 23:46
 * @Description 业务异常
 */
@Data
public class ServiceException extends RuntimeException {

    /***
     * 响应码
     */
    private Integer code;

    public ServiceException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ServiceException(String message) {
        super(message);
        this.code = ResultCodeEnum.UNKMON_ERROR.getCode();
    }


    public ServiceException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMsg());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "code=" + code + "," + this.getMessage() +
                '}';
    }
}
