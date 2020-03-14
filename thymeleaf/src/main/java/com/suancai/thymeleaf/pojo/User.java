package com.suancai.thymeleaf.pojo;

import lombok.Data;

/**
 * @Author Bruce
 * @Date: 2019/11/16 11:54
 * @Description
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
