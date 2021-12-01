package com.gm.test;

import com.gm.proxyFactory.CglibProxyFactory;
import com.gm.proxyFactory.ProcxyFactory;
import com.gm.service.UserService;
import com.gm.service.UserServiceImpl;
import org.junit.Test;

public class AopTest {

    @Test
    public void test1(){
        //创建代理对象
        UserService us = new UserServiceImpl();
        //创建代理工厂
        ProcxyFactory factory = new ProcxyFactory(us);
        //调用代理对象方法
        UserService usProxy = (UserService) factory.createProxy();

        usProxy.login();
        usProxy.regist();
    }

    @Test
    public void test2(){
        //创建代理对象
        UserServiceImpl us = new UserServiceImpl();
        //cglib创建代理工厂
        CglibProxyFactory factory = new CglibProxyFactory(us);
        //调用代理对象方法
        UserServiceImpl usProxy = (UserServiceImpl) factory.createProxy();

        usProxy.login();
        usProxy.regist();
    }
}
