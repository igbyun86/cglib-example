package com.cglibex;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean login(User user) {
		
		if (!"big".equals(user.getId())) {
			return false;
		}
		
		if (!"1234".equals(user.getPassword())) {
			return false;
		}
		
		System.out.println("login ¼º°ø!!");
		
		return true;
	}

	@Override
	public void logout(String id) {
		System.out.println("logout...");
	}

}
