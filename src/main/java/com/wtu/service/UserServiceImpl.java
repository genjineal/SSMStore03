package com.wtu.service;

import com.github.pagehelper.PageHelper;
import com.wtu.entity.User;
import com.wtu.mapper.UserMapper;
import com.wtu.util.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author chuang
 * @version 1.0
 * @date 2021/11/1 19:24
 */
@Service
public class UserServiceImpl  implements  UserService{
    //调用上一层接口
    @Autowired
    private UserMapper userMapper;
    //登录

    public User doLogin(Map map) {
        return userMapper.doLogin(map);
    }
    //注册

    public int regUser(Map map) {
        return userMapper.regUser(map);
    }
    //判断用户名是否重复

    public User isUser(Map map) {
        return userMapper.isUser(map);
    }
    //修改准备

    public User updateSelect(int uid) {
        return userMapper.updateSelect(uid);
    }
    //修改个人信息

    public int userUpdateSelf(Map map) {
        return userMapper.userUpdateSelf(map);
    }

    //管理所有用户信息 管理员端 带分页和条件查询

    public List<User> selectAllUser(Params params) {
        //默认初始第一页  动态给，用户第一次进入才给1
        if(params.getPageNum() ==0){
            params.setPageNum(1);
        }
        //需要当前页、每页条数
        PageHelper.startPage(params.getPageNum(),params.getPageSize());
        return userMapper.selectAllUser(params);
    }

    //管理员修改用户的信息 ① 根据id查到用户

    public User selectUserById(Integer uid) {
        return userMapper.selectUserById(uid);
    }

    //②执行修改操作

    public int updateUserById(Map map) {
        return userMapper.updateUserById(map);
    }

    // 管理员删除用户

    public int deleteUserById(Integer uid) {
        return userMapper.deleteUserById(uid);
    }

}
