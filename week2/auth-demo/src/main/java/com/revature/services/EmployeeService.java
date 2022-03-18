package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.daos.DaoFactory;
import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;
import com.revature.models.Role;

public class EmployeeService {

	private EmployeeDao ed;

	// Retrieving an instance of EmployeeDao
	public EmployeeService() {
		ed = DaoFactory.getDAOFactory().getEmployeeDao();
	}

	/**
	 * Service method to retrieve all employees, sets the employee passwords to null before returning them
	 * @return a List of Employees or an empty list if none are found
	 */
	public List<Employee> getEmployees(){
		/*
		 *  Java Streams, allows for quick processing of collections of objects (filter, map...)
		 *  	- here each Employee element of the employees List has their password set to null and are returned using the map method
		 *  	- the results are then collected back into a List
		 *  
		 *  for more information: https://www.baeldung.com/java-8-streams
		 */
		List<Employee> employees = ed.getEmployees().stream()
				.map(e -> {
					e.setPassword(null); 
					return e;})
				.collect(Collectors.toList());
		
		return employees;
	}
	
	/**
	 * Service method to retrieve all managers, sets the employee passwords to null before returning them
	 * @return a List of Employees or an empty list if none are found
	 */
	public List<Employee> getManagers(){
		List<Employee> employees = ed.getManagers().stream()
				.map(e -> {
					e.setPassword(null); 
					return e;})
				.collect(Collectors.toList());
		
		return employees;
	}
	
	/**
	 * Service method to retrieve employees by a manager id, sets the employee passwords to null before returning them
	 * @param id of the manager employee
	 * @return a List of Employees or an empty list if none are found
	 */
	public List<Employee> getEmployeesByManager(int id){
		List<Employee> employees = ed.getEmployeesByManagerId(id).stream()
				.map(e -> {
					e.setPassword(null); 
					return e;})
				.collect(Collectors.toList());
		
		return employees;
	}
	
	/**
	 * Service method to retrieve an employee by id, sets the employee password to null before returning
	 * @param id of the employee
	 * @return an employee or null if none is found
	 */
	public Employee getEmployeeById(int id){
		Employee e = ed.getEmployeeById(id);
		if (e != null) {
			e.setPassword(null);
		}
		
		return e;
	}
	
	/**
	 * Service method to retrieve an employee by its username, sets the employee password to null before returning
	 * @param username of the employee
	 * @return an employee or null if none is found
	 */
	public Employee getEmployeeByUsername(String username){
		Employee e = ed.getEmployeeByUsername(username);
		if (e != null) {
			e.setPassword(null);
		}
		
		return e;
	}
	
	/**
	 * Service method to create an employee, sets to a default manager and default role. The employee id assigned before returning it
	 * @param employee object, requires name, username, password 
	 * @return an employee with an id or null if none is created
	 */
	public Employee addEmployee(Employee e) {
		// assigning a default manager/role
		e.setManager(new Employee(1));
		e.setRole(Role.BASIC_EMPLOYEE);

		return ed.addEmployee(e);
	}
	
	/**
	 * Service method to update an employee's info (ONLY username, password, and name) based on their id
	 * @param employee object, requires an id and valid field values
	 * @return true if an employee was updated, else false
	 */
	public boolean updateEmployeeInfo(Employee e) {
		
		Employee e_update = ed.getEmployeeById(e.getId());
		
		// if name isn't null or the same update the name to a new value
		if(e.getName() != null && !e.getName().equals(e_update.getName())) {
			e_update.setName(e.getName());
		}
		
		// if username isn't null or the same update the name to a new value
		if(e.getUsername() != null && !e.getUsername().equals(e_update.getUsername())) {
			e_update.setUsername(e.getUsername());
		}
		
		// if password isn't null or the same update the name to a new value
		if(e.getPassword() != null && !e.getPassword().equals(e_update.getPassword())) {
			e_update.setPassword(e.getPassword());
		}
		
		return ed.updateEmployee(e_update);	
	}
	
	/**
	 * Service method to update an employee's admin info (ONLY manager, Role) based on their id
	 * @param employee object, requires an id and valid field values
	 * @return true if an employee was updated, else false
	 */
	public boolean updateEmployeeInfoAdmin(Employee e) {
		
		Employee e_update = ed.getEmployeeById(e.getId());
		
		// if manager isn't null or the same update the name to a new value
		if(e.getManager() != null && !e.getManager().equals(e_update.getManager())) {
			e_update.setManager(e.getManager());
		}
		
		// if Role isn't null or the same update the name to a new value
		if(e.getRole() != null && !e.getRole().equals(e_update.getRole())) {
			e_update.setRole(e.getRole());
		}

		return ed.updateEmployee(e_update);	
	}
}
