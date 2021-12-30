package com.hieu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieu.bean.Account;
import com.hieu.repository.inter.AccountRepos;
import com.hieu.service.inter.AccountSv;

@Service
public class AccountService implements AccountSv{

	@Autowired
	private AccountRepos accountRepos;
	
	@Override
	public boolean checkAccount(String username, String password) {
		if(accountRepos.checkAccount(username, password) == true) {
			return true;
		}
		return false;
	}

	@Override
	public boolean regiser(String name, String email, String password) {
		if(accountRepos.regiser(name, email, password)) {
			return true;
		}
		return false;
	}

	@Override
	public Account findAccount(String username) {
		return accountRepos.findAccount(username);
	}

	@Override
	public boolean CheckRoleAdmin(String username) {
		List<String> listRole = accountRepos.getRoleName(accountRepos.findAccount(username));
		for(int i=0; i<listRole.size(); i++) {
			if(listRole.get(i).equalsIgnoreCase("ROLE_ADMIN")) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkUserRole(String username) {
		List<String> listRole = accountRepos.getRoleName(accountRepos.findAccount(username));
		for(int i=0; i<listRole.size(); i++) {
			if(listRole.get(i).equalsIgnoreCase("ROLE_USER")) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkEmployeeRole(String username) {
		List<String> listRole = accountRepos.getRoleName(accountRepos.findAccount(username));
		for(int i=0; i<listRole.size(); i++) {
			if(listRole.get(i).equalsIgnoreCase("ROLE_EMPLOYEE")) {
				return true;
			}
		}
		return false;
	}
}
