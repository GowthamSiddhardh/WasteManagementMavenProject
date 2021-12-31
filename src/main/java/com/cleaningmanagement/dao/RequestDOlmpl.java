package com.cleaningmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.WasteManagementSystem.interfacedao.RequestDao;
import com.cleaningmanagement.model.Employee;
import com.cleaningmanagement.model.Request;
import com.cleaningmanagement.model.User;

public class RequestDOlmpl implements RequestDao {
	public boolean insertRequestDetails(Request req) {
		boolean flag = false;
		Connection con = ConnectionClass.getConnection();
		String query = "insert into WMS_request (user_id,emp_id,category,location) values (?,?,?,?)";
		try {
			EmployeeDOlmpl empDao = new EmployeeDOlmpl();
			UserDOlmpl userDao = new UserDOlmpl();
			int empId = empDao.findEmpId(req.getEmployee());
			int userId = userDao.findUserId(req.getUser());
			// System.out.println("Employee ID:"+empId);
			// System.out.println("User id:"+userId);
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, empId);
			pstmt.setString(3, req.getCatogories());
			pstmt.setString(4, req.getLocation());
			flag = pstmt.executeUpdate() > 0;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return flag;

	}

	public List<Request> showRequest() {
		Connection con = ConnectionClass.getConnection();
		List<Request> listRequest = new ArrayList<Request>();
		String query = "select * from WMS_request";
		Request request = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			UserDOlmpl userDao = new UserDOlmpl();
			EmployeeDOlmpl employeedao = new EmployeeDOlmpl();
			while (rs.next()) {
				User user = userDao.findUser(rs.getInt(2));
				// System.out.println(rs.getInt(2));
				Employee employee = employeedao.findEmployee(rs.getString(5));
				request = new Request(user, employee, rs.getString(4), rs.getString(5));
				listRequest.add(request);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRequest;

	}

	public int findRequestID(int userId, String category, String location) {
		Connection con = ConnectionClass.getConnection();
		String query = "select request_id from WMS_request where user_id=? and category=? and location=?";
		int n = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, userId);
			pstmt.setString(2, category);
			pstmt.setString(3, location);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	public boolean deleteRequest(int RequestId) {
		Connection con = ConnectionClass.getConnection();
		String deleteQuery = "delete from WMS_request where request_id=" + RequestId;
		boolean flag = false;
		try {
			Statement stmt = con.createStatement();
			flag = stmt.executeUpdate(deleteQuery) > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	public ResultSet billing() {
		Connection con = ConnectionClass.getConnection();
		String joinQuery = "select r.request_id,r.user_id,r.category,r.location,c.weight_kg,c.amount,r.emp_id from WMS_request r join Category_details c on r.category=c.categories";
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
	

}
