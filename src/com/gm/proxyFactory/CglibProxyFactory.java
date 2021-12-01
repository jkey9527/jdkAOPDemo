package com.gm.proxyFactory;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyFactory implements MethodInterceptor {

    //代理对象
    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    //创建代理对象方法
    public Object createProxy(){
        //enhancer对象
        Enhancer enhancer = new Enhancer();
        //传递目标对象的Class
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        //返回代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object procy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("日志记录操作。。。");
        return method.invoke(target,args);
    }
}
