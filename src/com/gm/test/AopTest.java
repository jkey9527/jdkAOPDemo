package com.gm.test;

import com.gm.procxyFactory.ProcxyFactory;
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
        UserService usProxy = (UserService) factory.createProcxy();

        usProxy.login();
        usProxy.regist();
    }
}
