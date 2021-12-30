package com.hieu.service.inter;

import com.hieu.bean.Account;

public interface AccountSv {

	boolean checkAccount(String username, String password);
	
	public boolean regiser(String name, String email, String password);
	
	public Account findAccount(String username);
	
	public boolean CheckRoleAdmin(String username);
	
	public boolean checkUserRole(String username);
	
	public boolean checkEmployeeRole(String username);
}
