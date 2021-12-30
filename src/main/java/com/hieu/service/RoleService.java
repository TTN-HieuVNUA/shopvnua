package com.hieu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieu.bean.Role;
import com.hieu.repository.inter.RoleRepos;
import com.hieu.service.inter.RoleSv;

@Service
public class RoleService implements RoleSv{

	@Autowired
	private RoleRepos roleRepos;
	
	@Override
	public List<Role> getListRole() {
		return roleRepos.getRole();
	}
	
}
