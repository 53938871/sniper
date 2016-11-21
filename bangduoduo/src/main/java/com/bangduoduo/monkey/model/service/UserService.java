package com.bangduoduo.monkey.model.service;

import com.bangduoduo.monkey.model.domain.User;
import com.bangduoduo.monkey.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(long id) {
        return userMapper.getUserById(id);
    }
}
