package com.suancai.multity.controller;

import com.suancai.multity.dao.BaseMapper;
import com.suancai.multity.pojo.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Bruce
 * @Date: 2020/3/14 12:08
 * @Description 用于验证取数逻辑
 */
@RestController
public class Controller {
    @Resource(name = "userMapperdb01")
    private BaseMapper userMapperdb01;

    @Resource(name = "userMapperdb02")
    private BaseMapper userMapperdb02;

    /**
     * 测试用户数据
     * @param type
     * @param id
     * @return
     */
    @RequestMapping("/get/{type}/{id}")
    public User getUserById(@PathVariable String type, @PathVariable long id){
        if ("db01".equals(type)){
           return userMapperdb01.selectByPrimaryKey(id);
        }
        return userMapperdb02.selectByPrimaryKey(id);
    }
}
