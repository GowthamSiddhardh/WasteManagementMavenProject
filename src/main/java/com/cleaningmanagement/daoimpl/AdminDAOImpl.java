package com.cleaningmanagement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.cleaningmanagement.dao.AdminDao;
import com.cleaningmanagement.model.Admin;
import com.cleaningmanagement.model.CategoryDetails;
import com.cleaningmanagement.util.ConnectionUtil;

public class AdminDAOImpl implements AdminDao {
	public Admin AdminDatabase(String adminEmail, String passWord) {
		Admin admin = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			String insertQuery = "select * from WMS_admin where admin_email='" + adminEmail + "'and admin_pwd='"
					+ passWord + "'";

			Statement pstmt = con.createStatement();
			ResultSet rs = pstmt.executeQuery(insertQuery);
			if (rs.next()) {
				admin = new Admin(adminEmail, passWord);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admin;

	}

	public ResultSet showrequest(String location) {
		Connection con = ConnectionUtil.getConnection();
		String joinQuery = "select r.request_id,r.user_id,r.category,r.location,c.weight_kg,c.amount,r.emp_id from WMS_request r "

				+ "join Category_details c on r.category=c.categories where r.location='" + location + "'";
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(joinQuery);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet showrequest1(String category) {
		Connection con = ConnectionUtil.getConnection();
		String joinQuery = "select r.request_id,r.user_id,r.category,r.location,r.emp_id,c.weight_kg,c.amount from WMS_request r "
				+ "join Category_details c on r.category=c.categories where r.category='" + category + "'";
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(joinQuery);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public int updateRequest(String status, int requestId) {
		Connection con = ConnectionUtil.getConnection();
		String updateQuery = "update WMS_request set status=? where request_id=?";
		int n = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, status);
			pstmt.setInt(2, requestId);
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n;

	}

}
