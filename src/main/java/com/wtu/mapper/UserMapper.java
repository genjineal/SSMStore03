package com.wtu.mapper;

import com.wtu.entity.User;
import com.wtu.util.Params;

import java.util.List;
import java.util.Map;

/**
 * @author chuang
 * @version 1.0
 * @date 2021/11/1 19:23
 */
public interface UserMapper {
    //登录
    User doLogin(Map map);

    //注册
    int regUser(Map map);
    //判断用户名是否重复
    User isUser(Map map);
    //修改准备
    User updateSelect(int uid);
    //修改个人信息
    int userUpdateSelf(Map map);

    //管理所有用户信息 管理员端
    List<User> selectAllUser(Params params);

    //管理员修改用户的信息 ① 根据id查到用户
    User selectUserById(Integer uid);
    //②执行修改操作
    int updateUserById(Map map);
    // 管理员删除用户
    int deleteUserById(Integer uid);
}
