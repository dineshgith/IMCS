package com.employee.mavenjdbc;

import java.util.List;

public class EmployeeDBOImplementation implements EmployeeDBO {
	EmployeeDAOImplementation dao = new EmployeeDAOImplementation();

	public boolean addEmployee(Employee employee) throws InvalidSalaryException {
		if (employee.getSalary() < 5000) {
			throw new InvalidSalaryException();
		}
		return dao.addEmployee(employee);
	}

	public boolean deleteEmployee(int id) throws EmployeeNotFoundException {
		return dao.deleteEmployee(id);
	}

	public boolean updateEmployee(Employee employee) throws EmployeeNotFoundException, InvalidSalaryException {
		return dao.updateEmployee(employee);

	}

	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

	public Employee getEmployeeUsingId(int id) throws EmployeeNotFoundException {
		return dao.getEmployeeUsingId(id);
	}

	public List<Employee> sortEmployeesByDepartmentNumber() {
		return dao.sortEmployeesByDepartmentNumber();
	}

	public List<Employee> sortEmployeesBySalary() {
		return dao.sortEmployeesBySalary();
	}

	public List<Employee> sortEmployeesById() {
		return dao.sortEmployeesById();
	}

	public List<Employee> sortEmployeesByNameAndSalary() {
		return dao.sortEmployeesByNameAndSalary();
	}

}
