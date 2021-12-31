package com.cleaningmanagement.model;

import java.util.Objects;

public class Request {
     private User user;
     private Employee employee;
     private String catogories;
     private String location;
	 public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "user=" + user + "\nemployee=" + employee + "\ncatogories=" + catogories + "\nlocation="
				+ location;
	}
	@Override
	public int hashCode() {
		return Objects.hash(catogories, employee, location, user);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return Objects.equals(catogories, other.catogories) && Objects.equals(employee, other.employee)
				&& Objects.equals(location, other.location) && Objects.equals(user, other.user);
	}
	public Request(User user, Employee employee, String catogories, String location) {
		super();
		this.user = user;
		this.employee = employee;
		this.catogories = catogories;
		this.location = location;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getCatogories() {
		return catogories;
	}
	public void setCatogories(String catogories) {
		this.catogories = catogories;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
     
	
     
     
}
