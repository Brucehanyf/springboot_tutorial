package com.suancai.thymeleaf.dao;


import com.suancai.thymeleaf.pojo.User;

/**
 * @Author Bruce
 * @Date: 2019/11/16 11:55
 * @Description
 */
public interface UserMapper {
    User getUserByName(String name);
}
