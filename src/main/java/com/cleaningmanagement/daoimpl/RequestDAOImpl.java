package com.cleaningmanagement.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cleaningmanagement.dao.RequestDao;
import com.cleaningmanagement.model.Employee;
import com.cleaningmanagement.model.Request;
import com.cleaningmanagement.model.User;
import com.cleaningmanagement.util.ConnectionUtil;

public class RequestDAOImpl implements RequestDao {
	public boolean insertRequestDetails(Request req) {
		boolean flag = false;
		Connection con = ConnectionUtil.getConnection();
		String query = "insert into WMS_request (user_id,emp_id,category,location) values (?,?,?,?)";
		try {
			EmployeeDAOImpl empDao = new EmployeeDAOImpl();
			UserDAOImpl userDao = new UserDAOImpl();
			// System.out.println(req);
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
			pstmt.executeUpdate("commit");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return flag;

	}

	public List<Request> showRequest() {
		Connection con = ConnectionUtil.getConnection();
		List<Request> listRequest = new ArrayList<Request>();
		String query = "select * from WMS_request";
		Request request = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			UserDAOImpl userDao = new UserDAOImpl();
			EmployeeDAOImpl employeedao = new EmployeeDAOImpl();
			// System.out.println("before while");
			while (rs.next()) {
				// System.out.println(rs.getString(4));
				// System.out.println(rs.getString(5));
				// System.out.println(rs.getString(6));
				User user = userDao.findUser(rs.getInt(2));
				// System.out.println(rs.getInt(2));
				Employee employee = employeedao.findEmployee(rs.getString(5));
				// System.out.println(user);
				// System.out.println(employee);
				request = new Request(rs.getInt(1), user, employee, rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getDate(8));

				listRequest.add(request);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listRequest;

	}

	public List<Request> showRequest(String search) {
		Connection con = ConnectionUtil.getConnection();
		List<Request> listRequest = new ArrayList<Request>();
		String que = "select * from WMS_request where category like '%" + search.toLowerCase()
				+ "%' or location like '%" + search.toLowerCase() + "%' or employeestatus  like '%"
				+ search.toLowerCase() + "%' or requeststatus like '%" + search.toLowerCase() + "%'";
		Request request = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(que);
			UserDAOImpl userDao = new UserDAOImpl();
			EmployeeDAOImpl employeedao = new EmployeeDAOImpl();
			// System.out.println("before while");
			while (rs.next()) {
                User user = userDao.findUser(rs.getInt(2));
                Employee employee = employeedao.findEmployee(rs.getString(5));
                request = new Request(rs.getInt(1), user, employee, rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7), rs.getDate(8));
                listRequest.add(request);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listRequest;

	}

	public int findRequestID(int userId, String category, String location) {
		Connection con = ConnectionUtil.getConnection();
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
		Connection con = ConnectionUtil.getConnection();
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
		Connection con = ConnectionUtil.getConnection();
		String joinQuery = "select r.request_id,r.user_id,r.category,r.location,c.weight_kg,c.amount,r.emp_id,r.request_date from WMS_request r join Category_details c on r.category=c.categories";
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

	public ResultSet CalculateAmount(String location, Date fromdate, Date todate) {
		Connection con = ConnectionUtil.getConnection();
		String query = "select sum(c.weight_kg) from Category_details c join WMS_request r on c.categories=r.category  where r.location=? and r.requeststatus='completed' and r.request_date between ? and ? group by r.location ";
		ResultSet rs = null;

		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, location);
			pstmt.setDate(2, new java.sql.Date(fromdate.getTime()));
			pstmt.setDate(3, new java.sql.Date(todate.getTime()));
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}

	@Override
	public ResultSet CalculateAmount(String location, java.sql.Date fromdate, java.sql.Date todate) {
		// TODO Auto-generated method stub
		return null;
	}

}
