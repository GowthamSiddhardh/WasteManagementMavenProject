package com.cleaningmanagement.model;

import java.util.Objects;

public class Employee {
	
	private String empEmail;
	private String empName;
	private String empPassWord;
	private String location;
	
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPassWord() {
		return empPassWord;
	}
	public void setEmpPassWord(String empPassWord) {
		this.empPassWord = empPassWord;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String empEmail, String empName, String empPassWord,String location) {
		super();
		
		this.empEmail = empEmail;
		this.empName = empName;
		this.empPassWord = empPassWord;
		this.location=location;
	}
	
	@Override
	public String toString() {
		return "Employee [empEmail=" + empEmail + ", empName=" + empName + ", empPassWord=" + empPassWord
				+ ", location=" + location + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(empEmail, empName, empPassWord);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empEmail, other.empEmail) && Objects.equals(empName, other.empName)
				&& Objects.equals(empPassWord, other.empPassWord);
	}
	
	

}
