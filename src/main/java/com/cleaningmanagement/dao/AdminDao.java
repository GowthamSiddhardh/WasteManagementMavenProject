package com.cleaningmanagement.dao;



import com.cleaningmanagement.model.Admin;

public interface AdminDao {
	public Admin AdminDatabase(String adminEmail, String passWord);
	public int updateRequest(String status,int requestId);
}
