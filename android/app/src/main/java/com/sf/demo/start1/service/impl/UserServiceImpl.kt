package com.sf.demo.start1.service.impl

import android.util.Log
import com.sf.demo.start1.dto.UserDto
import com.sf.demo.start1.service.UserService

class UserServiceImpl : UserService {


    override fun save(user: UserDto): UserDto {

        Log.i("USER","存储到数据库");
        return user;
    }

    override fun logout(): Boolean {
        return true;
    }

    override fun login(user: UserDto): Boolean {
        return (user.username.equals("admin") && user.password.equals("admin"))
    }

    override fun getLoginUser(): UserDto {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}