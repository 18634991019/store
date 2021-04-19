package com.store.service;

import com.store.mode.UserRegister;
import com.store.model.User;

/**
 * 作者：MaWeiZe
 * 2021/4/12
 */
public interface UserService {
    User getUserByPhoneAndPassword(String phone, String password);

    Integer insertUserByPhoneAndPassword(UserRegister user);

    User selectUserByPhone(String phone);

    Integer updatePassWordByPhone(String phone, String passWordNew);
}
