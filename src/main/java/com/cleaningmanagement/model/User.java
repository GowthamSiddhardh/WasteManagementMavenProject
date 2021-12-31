package com.cleaningmanagement.model;

import java.util.Objects;

public class User {
    private String userEmail;
    private String userName;
    private String userPwd;
    private String userAddress;
    private long userMobileNo;
    private Double wallet;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public long getUserMobileNo() {
		return userMobileNo;
	}
	public void setUserMobileNo(long userMobileNo) {
		this.userMobileNo = userMobileNo;
	}
	public Double getWallet() {
		return wallet;
	}
	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userEmail, String userName, String userPwd, String userAddress, long userMobileNo,
			Double wallet) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userAddress = userAddress;
		this.userMobileNo = userMobileNo;
		this.wallet = wallet;
	}
	@Override
	public String toString() {
		return "User [userEmail=" + userEmail + ", userName=" + userName + ", userPwd=" + userPwd + ", userAddress="
				+ userAddress + ", userMobileNo=" + userMobileNo + ", wallet=" + wallet + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(userAddress, userEmail, userMobileNo, userName, userPwd, wallet);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userAddress, other.userAddress) && Objects.equals(userEmail, other.userEmail)
				&& userMobileNo == other.userMobileNo && Objects.equals(userName, other.userName)
				&& Objects.equals(userPwd, other.userPwd) && Objects.equals(wallet, other.wallet);
	}
    
}