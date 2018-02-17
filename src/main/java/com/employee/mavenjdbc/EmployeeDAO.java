package com.employee.mavenjdbc;

import java.util.List;

public interface EmployeeDAO {
	boolean addEmployee(Employee employee);

	boolean deleteEmployee(int id);

	boolean updateEmployee(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeUsingId(int id);

	List<Employee> sortEmployeesBySalary();

	List<Employee> sortEmployeesByNameAndSalary();

	List<Employee> sortEmployeesById();

	List<Employee> sortEmployeesByDepartmentNumber();

}
