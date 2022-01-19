package com.cleaningmanagement.model;

import java.util.Date;
import java.util.Objects;

public class Request {
	 private int RequestId;
     private User user;
     private Employee employee;
     private String catogories;
     private String location;
     private String status;
     private Date requestDate;
     private String employeestatus;
	public int getRequestId() {
		return RequestId;
	}
	public void setRequestId(int requestId) {
		RequestId = requestId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	public String getEmployeestatus() {
		return employeestatus;
	}
	public void setEmployeestatus(String employeestatus) {
		this.employeestatus = employeestatus;
	}
	public Request(User user, Employee employee, String catogories, String location, Date requestDate) {
		super();
		this.user = user;
		this.employee = employee;
		this.catogories = catogories;
		this.location = location;
		this.requestDate = requestDate;
	}
	public Request(int requestId, User user, Employee employee, String catogories, String location, String status,
			Date requestDate) {
		super();
		RequestId = requestId;
		this.user = user;
		this.employee = employee;
		this.catogories = catogories;
		this.location = location;
		this.status = status;
		this.requestDate = requestDate;
	}
	
	public Request(int requestId, User user, Employee employee, String catogories, String location, String status, String employeestatus,
			Date requestDate) {
		super();
		RequestId = requestId;
		this.user = user;
		this.employee = employee;
		this.catogories = catogories;
		this.location = location;
		this.status = status;
		this.employeestatus = employeestatus;
		this.requestDate = requestDate;
		
	}
	@Override
	public String toString() {
		return "Request [user=" + user + ", employee=" + employee + ", catogories=" + catogories + ", location="
				+ location + ", requestDate=" + requestDate + "]";
	}
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(catogories, employee, location, requestDate, user);
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
				&& Objects.equals(location, other.location) && Objects.equals(requestDate, other.requestDate)
				&& Objects.equals(user, other.user);
	}
     
	
     
}
