package com.employee.mavenjdbc;

public class Employee {
	public Employee() {
		super();
	}

	private String name;
	private int empId;
	private double salary;
	private int deptNo;
	private float experience;

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public Employee(String name, int empId, double salary, int deptNo, float experience) {
		super();
		this.name = name;
		this.empId = empId;
		this.salary = salary;
		this.deptNo = deptNo;
		this.experience = experience;
	}

	public Employee(String name, int empId, double salary, int deptNo) {
		super();
		this.name = name;
		this.empId = empId;
		this.salary = salary;
		this.deptNo = deptNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [name=");
		builder.append(name);
		builder.append(", empId=");
		builder.append(empId);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", deptNo=");
		builder.append(deptNo);
		builder.append("]");
		return builder.toString();
	}
}