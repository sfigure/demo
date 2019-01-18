package com.sf.demo.start1.controller

import android.util.Log
import com.sf.demo.start1.dto.UserDto
import com.sf.demo.start1.service.impl.UserServiceImpl
import org.jetbrains.annotations.NotNull

class UserController {

    var userService = UserServiceImpl();
    /**
     * 用户名密码登录
     */
    fun loginByPassword(@NotNull loginName: String, @NotNull password: String): Boolean {
        Log.i("USER", " login: $loginName password: $password >");
        val user = UserDto(loginName, password);
        return userService.login(user);
    }


    fun logout(): Boolean {
        Log.i("USER", "logout <");
        userService.logout();
        return true;
    }

    /**
     * 判断用户登录状态
     */
    fun checkUserStatus() {

    }
}