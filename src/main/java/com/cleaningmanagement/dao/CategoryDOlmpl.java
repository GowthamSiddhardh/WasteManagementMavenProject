package com.cleaningmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.WasteManagementSystem.interfacedao.CategoryDao;
import com.cleaningmanagement.model.CategoryDetails;
import com.cleaningmanagement.model.User;

public class CategoryDOlmpl implements CategoryDao {
	public int insertCategoryDetails(CategoryDetails cat) {
		Connection con = ConnectionClass.getConnection();
		String insertQuery = "insert into Category_details values(?,?,?)";
		int n = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, cat.getWeightInKg());
			pstmt.setString(2, cat.getCategory());
			pstmt.setInt(3, cat.getAmount());
			n = pstmt.executeUpdate(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;

	}

	public CategoryDetails findAmount(String category) {
		Connection con = ConnectionClass.getConnection();
		String query = "select amount from Category_details where categories='" + category + "'";
		CategoryDetails cd = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				cd = new CategoryDetails(0, null, rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cd;

	}

	public List<CategoryDetails> listdetails() {
		Connection con = ConnectionClass.getConnection();
		List<CategoryDetails> list = new ArrayList<CategoryDetails>();
		String query = "select * from Category_details ";
		CategoryDetails cd = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				cd = new CategoryDetails(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(cd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
