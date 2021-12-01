package com.gm.test;


import com.gm.proxyFactory.ProcxyFactory;
import com.gm.service.UserService;
import com.gm.service.UserServiceImpl;
import org.junit.Test;

public class TestAop {
    @Test
    public void test1(){
        //目标对象
        UserService userService = new UserServiceImpl();
        //创建代理工厂
        ProcxyFactory proxyFactory = new ProcxyFactory(userService);
        //代理对象
        UserService procxy = (UserService) proxyFactory.createProxy();
        //调用代理对象的登录方法
        procxy.login();

        procxy.regist();
    }
}
