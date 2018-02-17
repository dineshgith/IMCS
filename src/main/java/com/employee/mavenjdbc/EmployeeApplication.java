package com.employee.mavenjdbc;

import java.util.Scanner;

public class EmployeeApplication {
	EmployeeDBOImplementation dboi = new EmployeeDBOImplementation();

	EmployeeApplication() {

	}

	private void addEmployee(Scanner sc) {
		Employee employee = new Employee();
		System.out.println("Enter Employee name, Ex:Bravo");
		String name = sc.next();
		employee.setName(name);
		System.out.println("Enter Employee ID");
		int id = sc.nextInt();
		employee.setEmpId(id);
		System.out.println("Enter Employee Salary, Ex:76773");
		int salary = sc.nextInt();
		employee.setSalary(salary);
		System.out.println("Enter Employee Department#, Ex: 121");
		int dept = sc.nextInt();
		employee.setDeptNo(dept);
		System.out.println("Enter Employee Experience, Ex: 5.5");
		float exp = sc.nextFloat();
		employee.setExperience(exp);

		try {
			dboi.addEmployee(employee);
		} catch (InvalidSalaryException e) {
			e.printStackTrace();
		}

	}

	private void updateEmployee(Scanner sc) {
		Employee empl = new Employee();
		System.out.println("Enter ID of an Employee you want to update");
		int id = sc.nextInt();
		empl.setEmpId(id);
		System.out.println("Enter name of an Employee, Ex:Bravo");
		String name = sc.next();
		empl.setName(name);
		System.out.println("Enter Employee Salary, Ex:76773");
		int salary = sc.nextInt();
		empl.setSalary(salary);
		System.out.println("Enter Employee Department#, Ex: 121");
		int dept = sc.nextInt();
		empl.setDeptNo(dept);
		System.out.println("Enter Employee Experience, Ex: 5.5");
		float exp = sc.nextFloat();
		empl.setExperience(exp);

		try {
			dboi.updateEmployee(empl);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidSalaryException e) {
			e.printStackTrace();
		}

	}

	private void getEmployeeUsingId(Scanner sc) {
		System.out.println("Enter ID of an Employee");
		int id = sc.nextInt();
		try {
			System.out.println(dboi.getEmployeeUsingId(id));
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void deleteEmployee(Scanner sc) {
		System.out.println("Enter ID of an Employee");
		int id = sc.nextInt();
		try {
			dboi.deleteEmployee(id);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void sortEmployeesBySalary() {
		System.out.println(dboi.sortEmployeesBySalary());
	}

	private void sortEmployeesByNameAndSalary() {
		System.out.println(dboi.sortEmployeesByNameAndSalary());

	}

	private void sortEmployeesByDepartmentNumber() {
		System.out.println(dboi.sortEmployeesByDepartmentNumber());

	}

	private void sortById() {
		System.out.println(dboi.sortEmployeesById());
	}

	public static void main(String[] args) {
		EmployeeApplication ea = new EmployeeApplication();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. CREATE an Employee");
			System.out.println("2. DELETE an Employee");
			System.out.println("3. UPDATE an Employee");
			System.out.println("4. GET Employee using ID");
			System.out.println("5. GET all Employees");
			System.out.println("6. SORT Employees by Salary");
			System.out.println("7. SORT Employees by Name and Salary");
			System.out.println("8. SORT Employees by Department#");
			System.out.println("9. SORT Employees by id");
			System.out.println("10.Exit");
			System.out.println("\n");
			System.out.println("Please Enter your choice.....");
			int selector = sc.nextInt();
			switch (selector) {
			case 1:
				ea.addEmployee(sc);
				break;

			case 2:
				ea.deleteEmployee(sc);
				break;

			case 3:
				ea.updateEmployee(sc);
				break;

			case 4:
				ea.getEmployeeUsingId(sc);
				break;

			case 5:
				System.out.println("List of all Employees");
				System.out.println(ea.dboi.getAllEmployees());
				break;

			case 6:
				ea.sortEmployeesBySalary();
				break;

			case 7:
				ea.sortEmployeesByNameAndSalary();
				break;

			case 8:
				ea.sortEmployeesByDepartmentNumber();
				break;

			case 9:
				ea.sortById();
				break;
			case 10:
				System.exit(0);
				break;

			}
		}

	}

}
