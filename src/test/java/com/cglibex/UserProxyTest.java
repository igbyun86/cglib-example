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
		// Enhancer default ����
		enhancer = new Enhancer();
		
		// setSuperclass() �޼ҵ忡 proxy�� Ŭ���� ����
		enhancer.setSuperclass(LoginServiceImpl.class);
		
		// user �ʱ�ȭ
		user = new User();
		user.setId("big");
		user.setName("");
		user.setPassword("1234");
    }
	
	
	/**
	 * intercept���� proxy ����
	 */
	//@Test
	public void loginServiceTest() {
		// �ƹ��۾��� �������� �ʰ� ���� ��ü�� ��ٷ� ȣ��
		enhancer.setCallback(NoOp.INSTANCE);
		
		Object obj = enhancer.create();
		LoginServiceImpl loginServiceImpl = (LoginServiceImpl) obj;
		loginServiceImpl.login(user);
	}
	
	/**
	 * LoginInterceptor �߰�
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
