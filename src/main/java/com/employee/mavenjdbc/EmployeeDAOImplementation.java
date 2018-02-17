package com.employee.mavenjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.util.ArrayList;

public class EmployeeDAOImplementation implements EmployeeDAO {
	Connection connection;
	PreparedStatement statement = null;

	public EmployeeDAOImplementation() {
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				
			}
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Chandu_19");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public boolean addEmployee(Employee employee) {
		if (employee != null)
			try {
				statement = connection
						.prepareStatement("Insert into employees(id, name, salary, department ) values(?,?, ?, ?) ");
				statement.setInt(1, employee.getEmpId());
				statement.setString(2, employee.getName());
				statement.setDouble(3, employee.getSalary());
				statement.setInt(4, employee.getDeptNo());
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return true;
	}

	public boolean deleteEmployee(int id) {
		try {
			statement = connection.prepareStatement("Delete from employees where id=?");
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	}

	public boolean updateEmployee(Employee employee)

	{
		try {
			statement = connection.prepareStatement("update employees set name=?, salary=?, department=? where id=?");
			statement.setString(1, employee.getName());
			statement.setDouble(2, employee.getSalary());
			statement.setInt(3, employee.getDeptNo());
			statement.setInt(4, employee.getEmpId());
			statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return true;

	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			statement = connection.prepareStatement("select * from employees");
			ResultSet rs = statement.executeQuery();
			Employee emp;
			if (rs != null)
				while (rs.next()) {

					emp = new Employee();
					emp.setEmpId(rs.getInt(1));
					emp.setName(rs.getString(2));
					emp.setSalary(rs.getFloat(3));
					emp.setDeptNo(rs.getInt(4));
					employees.add(emp);
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public Employee getEmployeeUsingId(int id) {
		Employee emp = null;
		try {
			statement = connection.prepareStatement("select * from employees where id=?");
			statement.setInt(1, id);
			ResultSet rs;
			rs = statement.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setName(rs.getString(2));
				emp.setDeptNo(rs.getInt(4));
				emp.setEmpId(rs.getInt(1));
				emp.setSalary(rs.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;

	}

	public List<Employee> sortEmployeesBySalary() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			statement = connection.prepareStatement("select * from employees order by salary");
			ResultSet rs = statement.executeQuery();
			Employee emp;

			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				emp.setDeptNo(rs.getInt(4));
				employees.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public List<Employee> sortEmployeesByNameAndSalary() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			statement = connection.prepareStatement("select * from employees order by name, salary");
			ResultSet rs = statement.executeQuery();
			Employee emp;

			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				emp.setDeptNo(rs.getInt(4));
				employees.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public List<Employee> sortEmployeesById() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			statement = connection.prepareStatement("select * from employees order by id");
			ResultSet rs = statement.executeQuery();
			Employee emp;

			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				emp.setDeptNo(rs.getInt(4));
				employees.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public List<Employee> sortEmployeesByDepartmentNumber() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			statement = connection.prepareStatement("select * from employees order by department");
			ResultSet rs = statement.executeQuery();
			Employee emp;

			while (rs.next()) {
				emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getFloat(3));
				emp.setDeptNo(rs.getInt(4));
				employees.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}
}
