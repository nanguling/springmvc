package com.mystudy.service;

import com.mystudy.mapper.UserMapper;
import com.mystudy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public User query(String username) {
        return mapper.query(username);
    }
}
