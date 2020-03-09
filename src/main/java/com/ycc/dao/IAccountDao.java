package com.ycc.dao;

import com.ycc.domain.Account;
import com.ycc.domain.AccountUser;

import java.util.List;

public interface IAccountDao {
    //查询所有账户
    List<Account> findAll();
    //查询所有账户，并且带有用户名称和地址信息
    List<AccountUser> findAllAccount();
}
