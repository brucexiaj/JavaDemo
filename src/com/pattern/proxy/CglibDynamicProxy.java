package com.pattern.proxy;

import java.lang.reflect.Method;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * 通过CGlib实现的动态代理模式:通过继承的方式实现
 * 所以被代理的类不能是final类（代码测试过）
 * 被代理的类如果有有参数构造函数，必须显式地提供无参数构造函数（代码测试过）
 * @author brucexia
 *
 */
public class CglibDynamicProxy implements MethodInterceptor{
	

    
   
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("代理调用之前");
		Object obj = arg3.invokeSuper(arg0, arg2);
		System.out.println("代理调用之后");
        return obj;
	}
	
	public static void main(String args[]) {
		Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DaiWan.class);
        enhancer.setCallback(new CglibDynamicProxy());
        DaiWan dog = (DaiWan)enhancer.create();
		
		dog.playVirus();
	}

}
