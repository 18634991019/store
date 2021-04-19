package com.store.controller;

import com.store.common.Result;
import com.store.enums.LoginEnum;
import com.store.mode.UserRegister;
import com.store.model.User;
import com.store.service.UserService;
import com.store.utils.MD5Util;
import com.sun.org.apache.regexp.internal.RE;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

import static com.store.enums.LoginEnum.*;


/**
 * 作者：MaWeiZe
 * 2021/4/12
 */


/**
 * 用户登录模块
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 用户注册模块
     * @param user
     * @return
     */
    @ResponseBody
    @GetMapping("/register")
    public Result register(UserRegister user){
        if (user.getIdentity()==null){
            return Result.error(USER_IDENTITY_NULL.getCode(), USER_IDENTITY_NULL.getMsg());
        }
        if (StringUtils.isNotBlank(user.getPassWord()) && StringUtils.isNotBlank(user.getPassWordTo())){
            if (!user.getPassWord().equals(user.getPassWordTo())){
                return Result.error(LoginEnum.PASSWORD_DIFFERENT.getCode(),LoginEnum.PASSWORD_DIFFERENT.getMsg());
            }
        }else {
            return Result.error(LoginEnum.PASSWORD_ISNULL.getCode(), LoginEnum.PASSWORD_ISNULL.getMsg());
        }
        User user1 = userService.selectUserByPhone(user.getPhone());
        if (user1!=null){
            return Result.error(USER_ISNOTNULL.getCode(), USER_ISNOTNULL.getMsg());
        }
        user.setPassWord(MD5Util.getMD5(user.getPassWord()));
        Integer count = userService.insertUserByPhoneAndPassword(user);
        if (count==0){
            return Result.error(USER_INSERT_FAILURE.getCode(), USER_INSERT_FAILURE.getMsg());
        }
        return Result.success();
    }

    /**
     * 登录模块
     * @param phone
     * @param password
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/index")
    public Result index(String phone, String password, HttpSession session){
        String passwordNew = MD5Util.getMD5(password);
        User user = userService.getUserByPhoneAndPassword(phone,passwordNew);
        if (user!=null){
            session.setAttribute("user", user);
            if (user.getIdentity()==null){
                return Result.error(USER_IDENTITY_NULL.getCode(), USER_IDENTITY_NULL.getMsg());
            }
            return Result.success(user);
        }else {
            return Result.error(USER_LOGIN_NOT.getCode(), USER_LOGIN_NOT.getMsg());
        }
    }

    /**
     * 忘记密码验证登录
     * @param phone
     * @param eMail
     * @return
     */
    @ResponseBody
    @GetMapping("/verify")
    public Result verifyByEMail(String phone, String eMail){
        User user = userService.selectUserByPhone(phone);
        if (!user.getEmail().equals(eMail)){
            return Result.error(USER_EMAIL_ERROR.getCode(), USER_EMAIL_ERROR.getMsg());
        }
        return Result.success();
    }


    @PostMapping("/amend")
    public Result amendPassWordByPhone(String phone,String passWord,String passWordTo){
        if (StringUtils.isNotBlank(passWord) && StringUtils.isNotBlank(passWordTo)){
            if (!passWord.equals(passWordTo)){
                return Result.error(LoginEnum.PASSWORD_DIFFERENT.getCode(),LoginEnum.PASSWORD_DIFFERENT.getMsg());
            }
        }else {
            return Result.error(LoginEnum.PASSWORD_ISNULL.getCode(), LoginEnum.PASSWORD_ISNULL.getMsg());
        }
        String passWordNew = MD5Util.getMD5(passWord);
        Integer count = userService.updatePassWordByPhone(phone,passWordNew);
        if (count==0){
            return Result.error(USER_INSERT_FAILURE.getCode(), USER_INSERT_FAILURE.getMsg());
        }
        return Result.success();


    }
}
