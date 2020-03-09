package com.ycc.dao;

import com.ycc.domain.User;

import java.util.List;

public interface IUserDao {
    //查询所有操作方法
    List<User> findAll();
    //查询某一个用户的信息
    User findById(int userId);
}
