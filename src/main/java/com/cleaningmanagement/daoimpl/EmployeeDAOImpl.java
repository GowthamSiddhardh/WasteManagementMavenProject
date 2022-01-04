package com.cleaningmanagement.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cleaningmanagement.dao.EmployeeDao;
import com.cleaningmanagement.model.Employee;
import com.cleaningmanagement.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDao {
	public boolean insertEmpDatabase(Employee emp) {
		boolean flag = false;
		Connection con = ConnectionUtil.getConnection();
		String query = "insert into  WMS_employee(emp_email,emp_name,emp_pwd,location) values(?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, emp.getEmpEmail());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpPassWord());
			pstmt.setString(4, emp.getLocation());
			flag = pstmt.executeUpdate() > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	public Employee validation(String email, String password) {
		Connection con = ConnectionUtil.getConnection();
		ResultSet rs = null;
		Employee emp = null;
		try {
			String query = "select * from WMS_employee where emp_email='" + email + "' and emp_pwd='" + password + "'";
			Statement pstmt = con.createStatement();
			rs = pstmt.executeQuery(query);
			if (rs.next()) {
				emp = new Employee(email, rs.getString(3), password, rs.getString(5));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;

	}

	public int findEmpId(Employee employee) {
		Connection con = ConnectionUtil.getConnection();
		String query = "select emp_id from WMS_employee where location= '" + employee.getLocation() + "'";
		int id = 0;
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public Employee findEmployee(String location) {
		Connection con = ConnectionUtil.getConnection();
		String query = "select * from WMS_employee where location= '" + location + "'";
		Employee emp = null;
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				System.out.println(rs.getString(2));
				emp = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;

	}

	public List<Employee> showEmployee() {
		Connection con = ConnectionUtil.getConnection();
		List<Employee> listemployee = new ArrayList<Employee>();
		String query = "select * from WMS_employee";
		Employee employee = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				employee = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				listemployee.add(employee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listemployee;

	}

	public int deleteEmployee(String email) {
		Connection con = ConnectionUtil.getConnection();
		String deleteQuery = "delete from WMS_employee where emp_email='" + email + "'";
		int n = 0;
		try {
			Statement stmt = con.createStatement();
			n = stmt.executeUpdate(deleteQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return n;

	}
	
	public ResultSet findEmployeeRequest(Employee employee) {
		Connection con = ConnectionUtil.getConnection();
		EmployeeDAOImpl employeedao=new EmployeeDAOImpl();
		int EmpId=employeedao.findEmpId(employee);
		System.out.println(employee+""+EmpId);
		String joinQuery = "select r.request_id,r.user_id,r.category,r.location,c.weight_kg,c.amount,r.emp_id,r.request_date from WMS_request r join Category_details c on r.category=c.categories "
				+ "where r.emp_id="+EmpId;
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
