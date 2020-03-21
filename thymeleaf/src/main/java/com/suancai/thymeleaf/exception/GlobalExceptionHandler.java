package com.suancai.thymeleaf.exception;

import com.suancai.thymeleaf.common.CommonResponse;
import com.suancai.thymeleaf.common.ResultCodeEnum;
import com.suancai.thymeleaf.utils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;

/**
 * @Author Bruce
 * @Date: 2020/3/20 23:34
 * @Description 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 通用异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResponse error(Exception e){
      log.error("全局异常处理：");
      e.printStackTrace();
      return CommonResponse.error();
    }

    /**
     * 指异常处理
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public CommonResponse error(NullPointerException e){
        e.printStackTrace();
        return CommonResponse.setResult(ResultCodeEnum.NPE);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    public CommonResponse error(IndexOutOfBoundsException e) {
        e.printStackTrace();
        return CommonResponse.setResult(ResultCodeEnum.HTTP_CLIENT_ERROR);
    }

    /**
     * 自定义定异常处理方法
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public CommonResponse error(ServiceException e) {
        e.printStackTrace();
        return CommonResponse.error().msg(ExceptionUtil.getMessage(e)).code(e.getCode());
    }
}
