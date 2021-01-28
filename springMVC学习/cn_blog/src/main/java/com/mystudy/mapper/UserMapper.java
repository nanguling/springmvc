package com.mystudy.mapper;

import com.mystudy.base.BaseMapper;
import com.mystudy.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User query(String username);
}