package com.suancai.multity.dao;

import com.suancai.multity.pojo.User;

/**
 * @Author Bruce
 * @Date: 2020/3/14 12:30
 * @Description mapper标识 用于controller 注入相同的mapper
 */
public interface BaseMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}