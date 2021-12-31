package com.cleaningmanagement.model;

import java.util.Objects;

public class Admin {
  
   private String adminEmail;
   private String adminPwd;
   


public String getAdminName() {
	return adminEmail;
}
public void setAdminName(String adminName) {
	this.adminEmail = adminName;
}
public String getAdminPwd() {
	return adminPwd;
}
public void setAdminPwd(String adminPwd) {
	this.adminPwd = adminPwd;
}

public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin( String adminEmil, String adminPwd) {
	super();
	
	this.adminEmail = adminEmail;
	this.adminPwd = adminPwd;
	
}
@Override
public String toString() {
	return " adminEmail=" + adminEmail + "\nadminPwd=" + adminPwd ;
}
@Override
public int hashCode() {
	return Objects.hash( adminEmail ,adminPwd);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Admin other = (Admin) obj;
	return  Objects.equals(adminEmail, other.adminEmail)
			&& Objects.equals(adminPwd, other.adminPwd);
}
   
}
