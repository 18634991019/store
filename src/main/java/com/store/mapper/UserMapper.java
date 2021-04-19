package com.store.mapper;

import com.store.mode.UserRegister;
import com.store.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User getUserByPhoneAndPassword(@Param("phone") String phone,
                                   @Param("password") String password);

    Integer insertUserByPhoneAndPassword(@Param("user") UserRegister user);

    User selectUserByPhone(@Param("phone") String phone);

    Integer updatePassWordByPhone(@Param("phone") String phone, @Param("password") String password);
}