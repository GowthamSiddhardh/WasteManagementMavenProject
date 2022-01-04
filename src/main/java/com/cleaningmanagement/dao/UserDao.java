package com.cleaningmanagement.dao;

import java.sql.ResultSet;

import com.cleaningmanagement.model.CategoryDetails;
import com.cleaningmanagement.model.User;

public interface UserDao {
	public boolean insertUserDatabase(User user);
	public User validateUser(String email, String password);
	public int findUserId(User user);
	public User findUser(int id);
	public int findUser(String email);
	public ResultSet userBill(User user);
	public boolean rechargeWallet(User user);
	public boolean updateWallet(User user, int amount);
	public boolean refundWallet(User user, int amount);
}
