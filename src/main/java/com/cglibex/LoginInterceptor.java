package com.cglibex;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class LoginInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

		String methodName = method.getName();
		if ("login".equals(methodName)) {
			System.out.println("login전 session 체크!");
		}
		else if ("logout".equals(methodName)) {
			System.out.println("logout전 session 체크!");
		}
		
		// 실행 method
		Object returnValue = proxy.invokeSuper(obj, args);
		
		return returnValue;
	}

	
}
