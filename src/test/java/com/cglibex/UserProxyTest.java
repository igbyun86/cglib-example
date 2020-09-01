package com.cglibex;

import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class UserProxyTest {

	static Enhancer enhancer;
	static User user;
	
	@BeforeClass 
	public static void onlyOnce() {
		// Enhancer default 설정
		enhancer = new Enhancer();
		
		// setSuperclass() 메소드에 proxy할 클래스 지정
		enhancer.setSuperclass(LoginServiceImpl.class);
		
		// user 초기화
		user = new User();
		user.setId("big");
		user.setName("");
		user.setPassword("1234");
    }
	
	
	/**
	 * intercept없이 proxy 실행
	 */
	//@Test
	public void loginServiceTest() {
		// 아무작업도 수행하지 않고 원본 객체를 곧바로 호출
		enhancer.setCallback(NoOp.INSTANCE);
		
		Object obj = enhancer.create();
		LoginServiceImpl loginServiceImpl = (LoginServiceImpl) obj;
		loginServiceImpl.login(user);
	}
	
	/**
	 * LoginInterceptor 추가
	 */
	@Test
	public void loginInterceptorTest() {
		enhancer.setCallback(new LoginInterceptor());
		
		Object obj = enhancer.create();
		LoginServiceImpl loginServiceImpl = (LoginServiceImpl) obj;
		loginServiceImpl.login(user);
	}
	
	@Test
	public void callbasksTest() {
		
	}
	
	@Test
	public void callbackFilterTest() {
		
	}
}
