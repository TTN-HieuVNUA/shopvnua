package com.hieu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hieu.bean.Role;
import com.hieu.service.inter.RoleSv;

@RestController
public class TestApi {

	@Autowired
	private RoleSv roleSv;
	
	@GetMapping(value = "api/test")
	public ResponseEntity<List<Role>> getList(){
		List<Role> list= roleSv.getListRole();
		
		return ResponseEntity.ok().body(list);
	}
}
