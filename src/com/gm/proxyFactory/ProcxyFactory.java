package com.gm.proxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProcxyFactory implements InvocationHandler {

    //目标对象
    private Object target;

    public ProcxyFactory(Object target) {
        this.target = target;
    }

    public Object createProxy(){
        //目标类的类加载器
        ClassLoader loader = target.getClass().getClassLoader();
        //目标类实现的接口Class[]
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader,interfaces,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法增强
        System.out.println("记录日志。。。");
        return method.invoke(target,args);
    }
}
