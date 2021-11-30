package com.gm.procxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler {
    //目标对象
    private Object target;


    public ProxyFactory(Object target) {
        this.target = target;
    }

    //创建代理对象
    public Object createProcxy(){
        //目标的类加载器
        ClassLoader loader = target.getClass().getClassLoader();
        //目标类实现的接口Class[]
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader,interfaces,this);

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //增强功能
        System.out.println("日志记录。。。");
        return method.invoke(target,args);
    }
}
