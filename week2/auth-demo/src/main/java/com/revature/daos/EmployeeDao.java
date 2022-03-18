package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDao {

	List<Employee> getEmployees();
	
	List<Employee> getManagers();

	List<Employee> getEmployeesByManagerId(int id);

	Employee getEmployeeById(int id);

	Employee getEmployeeByUsername(String username);

	Employee addEmployee(Employee e);

	boolean updateEmployee(Employee e);

}
