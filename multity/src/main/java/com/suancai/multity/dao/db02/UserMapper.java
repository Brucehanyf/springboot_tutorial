package com.suancai.multity.dao.db02;

import com.suancai.multity.dao.BaseMapper;
import com.suancai.multity.pojo.User;
import org.springframework.stereotype.Repository;

@Repository("userMapperdb02")
public interface UserMapper extends BaseMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}