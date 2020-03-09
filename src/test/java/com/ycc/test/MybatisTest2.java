package com.ycc.test;

import com.ycc.dao.IAccountDao;
import com.ycc.domain.Account;
import com.ycc.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest2 {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;
    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory= builder.build(in);
        //3.使用工厂生产SqlSession对象
        sqlSession = factory.openSession();
        //4.使用SqlSession创建Dao接口的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }
    @After//用于在测试方法执行之后执行
    public void destory() throws IOException {
        //提交事务
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }
    //测试查询所有用户
    @Test
    public void testFindAll(){
        //5.执行查询所有方法
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println("---每一次account---");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
    //测试查询所有用户,并且包含用户名称和地址
    @Test
    public void testFindAllAccount(){
        //5.执行查询所有方法
        List<AccountUser> au = accountDao.findAllAccount();
        for (AccountUser accountUser : au) {
            System.out.println(accountUser);
        }
    }
}
