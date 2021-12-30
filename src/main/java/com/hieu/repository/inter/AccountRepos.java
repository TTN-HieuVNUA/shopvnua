package com.hieu.repository.inter;

import java.util.List;

import com.hieu.bean.Account;

public interface AccountRepos {

	boolean regiser(String name, String username, String password);
	
	boolean checkAccount(String username, String password);
	
	Account findAccount(String username);
	
	List<String> getRoleName(Account account);
}
