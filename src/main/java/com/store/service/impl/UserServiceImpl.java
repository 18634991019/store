package com.store.service.impl;

import com.store.mapper.UserMapper;
import com.store.mode.UserRegister;
import com.store.model.User;
import com.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 作者：MaWeiZe
 * 2021/4/12
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByPhoneAndPassword(String phone, String password) {
        return userMapper.getUserByPhoneAndPassword(phone,password);
    }

    @Override
    public Integer insertUserByPhoneAndPassword(UserRegister user) {
        return userMapper.insertUserByPhoneAndPassword(user);
    }

    @Override
    public User selectUserByPhone(String phone) {
        return userMapper.selectUserByPhone(phone);
    }

    @Override
    public Integer updatePassWordByPhone(String phone, String password) {
        return userMapper.updatePassWordByPhone(phone,password);
    }
}
