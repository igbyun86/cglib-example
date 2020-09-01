package com.cglibex;

public interface LoginService {

	boolean login(User user);
	
	void logout(String id);
}
