package com.cleaningmanagement.dao;

import java.sql.ResultSet;

import com.cleaningmanagement.model.Admin;

public interface AdminDao {
	public Admin AdminDatabase(String adminEmail, String passWord);
	public ResultSet showrequest(String location);
	public ResultSet showrequest1(String category);
	public int updateRequest(String status, int requestId);
}
