package com.gm.test;

import com.gm.procxyFactory.ProxyFactory;
import com.gm.service.UserService;
import com.gm.service.UserServiceImpl;
import org.junit.Test;

public class TestAop {
    @Test
    public void test1(){
        //目标对象
        UserService userService = new UserServiceImpl();
        //创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory(userService);
        //代理对象
        UserService procxy = (UserService) proxyFactory.createProcxy();
        //调用代理对象的登录方法
        procxy.login();
        //调用代理对象的注册方法
        procxy.regist();
    }
}
