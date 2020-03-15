package com.suancai.thymeleaf.dto;

import lombok.Data;

/**
 * @Author Bruce
 * @Date: 2020/3/15 16:20
 * @Description 用户Model
 */
@Data
public class UserDto {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String varifyCode;
}