package com.jvm.classoom;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * 使用CGlib动态代理技术模拟jdk1.8中的方法区发生OOM错误
 * 1.8中的方法区又叫做元空间（Metaspace）
 * 运行方法：右键项目，选择Run As -> Run Configurations -> Arguments -> VM Arguments，填入下一行的内容：
 * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
 * 然后启动程序即可
 * @author brucexia
 *
 */
public class ClassAreaOOM {
	public static void main(final String[] args) {
        while (true){
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(ClassAreaOOM.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o,args);
                }
            });
            enhancer.create();
        }
    }

}
