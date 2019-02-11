package com.sf.spring.dao;

import com.sf.spring.dataobject.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author jzx
 * @date 2019/02/11 14:51
 * @Description:
 */
@Mapper
public interface UserDao {
    /**
     * 获取用户列表
     * @return
     */
    @Select("select * from test_user_1")
    List<User>  getUserList();
}
