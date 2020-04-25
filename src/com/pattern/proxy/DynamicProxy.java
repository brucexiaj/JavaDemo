package com.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 通过JDK反射实现的动态代理
 * @author brucexia
 *
 */
public class DynamicProxy implements InvocationHandler{
	private Object object;
	public DynamicProxy(Object object) {
		this.object = object;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理调用之前");
		method.invoke(object, args);
		System.out.println("代理调用之后");
		return null;
	}
	
	public static void main(String args[]) {
		IPlayVirus america = new America();
        
        DynamicProxy dynamicProxy = new DynamicProxy(america);

        IPlayVirus proxyVirus = (IPlayVirus) Proxy.newProxyInstance(america.getClass().getClassLoader(), america.getClass().getInterfaces(), dynamicProxy);

        proxyVirus.playVirus();
	}
	
	
}
