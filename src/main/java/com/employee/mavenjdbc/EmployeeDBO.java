package com.employee.mavenjdbc;

import java.util.List;

public interface EmployeeDBO {
	public boolean addEmployee(Employee employee) throws InvalidSalaryException;

	public boolean deleteEmployee(int id) throws EmployeeNotFoundException;

	public boolean updateEmployee(Employee employee) throws EmployeeNotFoundException, InvalidSalaryException;

	public List<Employee> getAllEmployees();

	public Employee getEmployeeUsingId(int id) throws EmployeeNotFoundException;

	public List<Employee> sortEmployeesByDepartmentNumber();

	public List<Employee> sortEmployeesBySalary();

	public List<Employee> sortEmployeesById();

	public List<Employee> sortEmployeesByNameAndSalary();
}
