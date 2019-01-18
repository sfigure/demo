package com.sf.demo.start1.service

import com.sf.demo.start1.dto.UserDto

interface UserService {

    fun logout():Boolean;

    fun login(user: UserDto):Boolean;
    /**
     * 保存用户信息
     */
    fun save(user:UserDto):UserDto;
    /**
     * 获取登录用户
     */
    fun  getLoginUser():UserDto;
}