package com.hieu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hieu.bean.Employee;
import com.hieu.repository.inter.EmployeeRpos;
import com.hieu.service.inter.EmployeeSv;

@Service
public class EmployeeService implements EmployeeSv{

	@Autowired
	private EmployeeRpos employeeRpos;
	
	@Override
	public List<Employee> getListEmployee() {
		return employeeRpos.getListEmployee();
	}

}
