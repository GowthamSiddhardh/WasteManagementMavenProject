package com.cleaningmanagement.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.cleaningmanagement.dao.AdminDOlmpl;
import com.cleaningmanagement.dao.CategoryDOlmpl;
import com.cleaningmanagement.dao.ConnectionClass;
import com.cleaningmanagement.dao.EmployeeDOlmpl;
import com.cleaningmanagement.dao.RequestDOlmpl;
import com.cleaningmanagement.dao.UserDOlmpl;
import com.cleaningmanagement.model.Admin;
import com.cleaningmanagement.model.CategoryDetails;
import com.cleaningmanagement.model.Employee;
import com.cleaningmanagement.model.Request;
import com.cleaningmanagement.model.User;

public class WmsMain {

	public static void main(String[] args) throws SQLException {
		EmployeeDOlmpl empdao = null;
		String validateEmail = null;
		Scanner sc = new Scanner(System.in);
		int empId1 = 0;
		System.out.println("1 Admin \n2 User \n3 Employee ");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			String adminEmail = null;
			String passWord = null;
			Admin admin = null;
			do {
				System.out.println("login");

				do {
					System.out.println("enter the adminEmail");
					adminEmail = sc.nextLine();
					if (!adminEmail.matches("[a-zA-z][a-zA-z0-9]+[@][a-z]+[.][a-z]{2,3}")) {
						System.out.println("email should be in abc@gamil.com");
					}
					if (adminEmail.isEmpty()) {
						System.out.println("name cant be empty");
					}
				} while (!adminEmail.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]{2,3}"));
				do {
					System.out.println("enter the password");
					passWord = sc.nextLine();
					if (!passWord.matches("[a-zA-z0-9&@#$_]{8,15}")) {
						System.out.println("password doesnot matches the condition");
					}
					if (passWord.isEmpty()) {
						System.out.println("password not be empty");
					}
				} while (!passWord.matches("[a-zA-z0-9&@#$_]{8,15}") || passWord.isEmpty());
				AdminDOlmpl ad = new AdminDOlmpl();
				admin = ad.AdminDatabase(adminEmail, passWord);
				if (admin != null) {
					System.out.println("welcome");
				} else {
					System.out.println("invalid username and password");
				}
			} while (admin == null);

			System.out.println("enter the employee details");
			System.out.println("\n1 Add Employees \n2 showEmployee \n3 delete Employee "
					+ "\n4 ViewRequestDetails \n5 Filter RequestDetails According to location \n6 Filter RequestDetails According to category"
					+ "\n7 update the Request status ");
			int i = Integer.parseInt(sc.nextLine());
			switch (i) {
			case 1:
				char c = 'y';
				while (c == 'y') {
					String empEmail = null;
					String empName = null;
					String empPassword = null;
					String location = null;
					boolean b = false;
					do {
						System.out.println("enter the employee email");
						empEmail = sc.nextLine();
						if (!empEmail.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]{2,3}")) {
							System.out.println("email should be in abc@gamil.com");
						}
						if (empEmail.isEmpty()) {
							System.out.println("cant be empty");
						}
					} while (!empEmail.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]{2,3}") || empEmail.isEmpty());
					do {
						System.out.println("enter the employee name");
						empName = sc.nextLine();
						if (!empName.matches("[a-zA-z]+{18}")) {
							System.out.println("name should not have the numbers");
						}
						if (empName.isEmpty()) {
							System.out.println("name cant be empty");
						}
					} while (!empName.matches("[a-zA-z]+{18}") || empName.isEmpty());
					do {
						System.out.println("enter the employee Password");
						empPassword = sc.nextLine();
						if (!empPassword.matches("[a-zA-z0-9&@#$_]{8,15}")) {
							System.out.println("password doesnot matches the condition");
						}
						if (empPassword.isEmpty()) {
							System.out.println("password not be empty");
						}
					} while (!empPassword.matches("[a-zA-z0-9&@#$_]{8,15}") || empPassword.isEmpty());
					do {
						System.out.println("enter the location");
						location = sc.nextLine();
						if (location.isEmpty()) {
							System.out.println("location should not be empty");
						}
						if (!location.matches("[a-zA-Z]+")) {
							System.out.println("location should be alphabets only");
						}
					} while (location.isEmpty() || !location.matches("[a-zA-Z]+"));
					Employee emp = new Employee(empEmail, empName, empPassword, location);
					empdao = new EmployeeDOlmpl();
					b = empdao.insertEmpDatabase(emp);
					if (b == true) {
						System.out.println("registered successfully");
					} else {
						System.out.println("not registered successfully");
					}
//	    		empId1=empdao.findEmpId(location);
//	    	    System.out.println(empId1);
					System.out.println("do you want to add some more employee(y/n):");
					c = sc.nextLine().charAt(0);

				}
				break;

			case 2:
				EmployeeDOlmpl employeedao = new EmployeeDOlmpl();
				List<Employee> list = employeedao.showEmployee();
				for (int j = 0; j < list.size(); j++) {
					System.out.println(list.get(j));
				}
				break;
			case 3:
				int n = 0;
				System.out.println("enter the email");
				String employeeEmail = sc.nextLine();
				EmployeeDOlmpl employeedao1 = new EmployeeDOlmpl();
				n = employeedao1.deleteEmployee(employeeEmail);
				if (n > 0) {
					System.out.println(n + " " + "row deleted");
				} else {
					System.out.println("no records are deleted");
				}
				break;
			case 4:
				System.out.println("viewRequestDetails");
				RequestDOlmpl requestDao = new RequestDOlmpl();
				ResultSet rs = requestDao.billing();
				System.out.format("%-10s%-10s%-15s%-10s%-15s%-10s%-10s\n", "RequestId", "UserId", "category",
						"location", "weight", "amount", "EmployeeId");
				System.out.println(
						"------------------------------------------------------------------------------------------");
				while (rs.next()) {
					System.out.format("%-10s%-10s%-15s%-10s%-15s%-10s%-10s\n", rs.getInt(1), rs.getInt(2),
							rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
				}
				break;
			case 5:
				System.out.println("Filter According to location");
				System.out.println("enter the location");
				String location = sc.nextLine();
				AdminDOlmpl admindao = new AdminDOlmpl();
				ResultSet rst = admindao.showrequest(location);
				System.out.format("%-10s%-10s%-15s%-10s%-15s%-10s%-10s\n", "RequestId", "UserId", "category",
						"location", "weight", "amount", "EmployeeId");
				System.out.println(
						"------------------------------------------------------------------------------------------");
				while (rst.next()) {
					System.out.format("%-10s%-10s%-15s%-10s%-15s%-10s%-10s\n", rst.getInt(1), rst.getInt(2),
							rst.getString(3), rst.getString(4), rst.getInt(5), rst.getInt(6), rst.getInt(7));
				}
				break;
			case 6:
				System.out.println("Filter According to category");
				System.out.println("enter the category");
				String category = sc.nextLine();
				AdminDOlmpl admindao1 = new AdminDOlmpl();
				ResultSet resultset = admindao1.showrequest1(category);
				System.out.format("%-10s%-10s%-15s%-10s%-15s%-10s%-10s\n", "RequestId", "UserId", "category",
						"location", "EmployeeId", "weight_kg", "Amount");
				System.out.println(
						"------------------------------------------------------------------------------------------");
				while (resultset.next()) {
					System.out.format("%-10s%-10s%-15s%-10s%-15s%-10s%-10s\n", resultset.getInt(1), resultset.getInt(2),
							resultset.getString(3), resultset.getString(4), resultset.getInt(5), resultset.getInt(6),
							resultset.getInt(7));
				}
				break;
			case 7:
				int j = 0;
				System.out.println("update the status");
				String status = sc.nextLine();
				System.out.println("enter the RequestId");
				int requestId = Integer.parseInt(sc.nextLine());
				AdminDOlmpl admindao2 = new AdminDOlmpl();
				j = admindao2.updateRequest(status, requestId);
				if (j > 0) {
					System.out.println(j + " " + "row updated");
				} else {
					System.out.println("not updated properly");
				}
			case 8:
				System.out.println("enter the weight");
				int weight = Integer.parseInt(sc.findInLine(sc.nextLine()));
				System.out.println("enter the category");
				String category1 = sc.nextLine();
				System.out.println("enter the amount");
				int amount = Integer.parseInt(sc.nextLine());
				CategoryDetails c1 = new CategoryDetails(weight, category1, amount);
				CategoryDOlmpl categorydao = new CategoryDOlmpl();
				int k = categorydao.insertCategoryDetails(c1);
				if (k > 0) {
					System.out.println(k + " " + "inserted successfully");
				} else {
					System.out.println("not inserted successfully");
				}

			}
			break;

		case 2:
			System.out.println("\nUser\n1 UserRegistration \n2 UserValidation");
			int j = Integer.parseInt(sc.nextLine());
			User user1 = null;
			switch (j) {
			case 1:
				String userEmail = null;
				String userName = null;
				String userPassword = null;
				String userAddress = null;
				long mobileNo = 0;

				do {
					System.out.println("enter the user email");
					userEmail = sc.nextLine();
					if (!userEmail.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]{2,3}")) {
						System.out.println("email should be in abc@gamil.com");
					}
					if (userEmail.isEmpty()) {
						System.out.println("cant be empty");
					}
				} while (!userEmail.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]{2,3}") || userEmail.isEmpty());
				do {
					System.out.println("enter the user name");
					userName = sc.nextLine();
					if (!userName.matches("[a-zA-z]+{32}")) {
						System.out.println("name should not have the numbers");
					}
					if (userName.isEmpty()) {
						System.out.println("name cant be empty");
					}
				} while (!userName.matches("[a-zA-z]+{32}") || userName.isEmpty());
				do {
					System.out.println("enter the user Password");
					userPassword = sc.nextLine();
					if (!userPassword.matches("[a-zA-z0-9&@#$_]{8,15}")) {
						System.out.println("password doesnot matches the condition");
					}
					if (userPassword.isEmpty()) {
						System.out.println("password not be empty");
					}
				} while (!userPassword.matches("[a-zA-z0-9&@#$_]{8,15}") || userPassword.isEmpty());
				do {
					System.out.println("enter the user Address");
					userAddress = sc.nextLine();
					if (!userAddress.matches("[0-9a-zA-Z/,.]+{50}")) {
						System.out.println("Address is not in proper format");
					}
				} while (!userAddress.matches("[0-9a-zA-Z/,.]+{50}"));
				String tempno = null;
				do {
					System.out.println("enter the mobile number");
					tempno = sc.nextLine();
					if (!tempno.matches("[0-9]+{10}")) {
						System.out.println("mobile number should not contains alphabets");
					}
					if (tempno.isEmpty()) {
						System.out.println("mobile number should be empty");
					}
				} while (!tempno.matches("[0-9]+{10}") || tempno.isEmpty());
				mobileNo = Long.parseLong(tempno);
				// Double wallet=0.0;
				User user = new User(userEmail, userName, userPassword, userAddress, mobileNo, 0.0);
				UserDOlmpl ud = new UserDOlmpl();
				boolean a = ud.insertUserDatabase(user);
				System.out.println("inserted successfully");
				break;
			case 2:

				String validateUseremail = null;
				String validateUserPwd = null;
				String catagories = null;
				String location = null;
				Request req = null;

				do {
					System.out.println("login");

					do {
						System.out.println("enter the user email");
						validateUseremail = sc.nextLine();
						if (!validateUseremail.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]{2,3}")) {
							System.out.println("email should be in abc@gamil.com");
						}
					} while (!validateUseremail.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]{2,3}"));
					do {
						System.out.println("enter the user password");
						validateUserPwd = sc.nextLine();
						if (!validateUserPwd.matches("[a-zA-z0-9&@#$_]{8,15}")) {
							System.out.println("password doesnot matches the condition");
						}
						if (validateUserPwd.isEmpty()) {
							System.out.println("password should not be empty");
						}
					} while (!validateUserPwd.matches("[a-zA-z0-9&@#$_]{8,15}") || validateUserPwd.isEmpty());

					UserDOlmpl udd = new UserDOlmpl();
					user1 = udd.validateUser(validateUseremail, validateUserPwd);
					if (user1 != null) {
						System.out.println("welcome" + " " + user1.getUserName());
						System.out.println("\n1 ViewCategory \n2 RaiseRequest \n3 cancleRequest \n4 rechargeWallet");
						int choice1 = Integer.parseInt(sc.nextLine());
						switch (choice1) {
						case 1:
							CategoryDOlmpl CD = new CategoryDOlmpl();
							List<CategoryDetails> listdetails = CD.listdetails();
							for (int c = 0; c < listdetails.size(); c++) {
								System.out.println(listdetails.get(c));
							}
						case 2:
							EmployeeDOlmpl empDao = new EmployeeDOlmpl();
							// int userId=uid.findUserId(validateUseremail);
							System.out.println("enter the catagories");
							catagories = sc.nextLine();
							System.out.println("enter the location");
							location = sc.nextLine();
							Employee employee = empDao.findEmployee(location);
							req = new Request(user1, employee, catagories, location);
							RequestDOlmpl rd = new RequestDOlmpl();
							boolean b = rd.insertRequestDetails(req);
							int amount = 0;
							if (b == true) {
								System.out.println("request details are updated successfully");
								UserDOlmpl userdao = new UserDOlmpl();
								ResultSet rs = userdao.userBill(user1);
								System.out.format("%-10s%-10s%-15s%-10s%-10s%-10s\n", "RequestId", "UserId", "category",
										"weight_kg", "Amount", "EmployeeId");
								System.out.println(
										"-----------------------------------------------------------------------");
								while (rs.next()) {
									System.out.format("%-10s%-10s%-15s%-10s%-10s%-10s\n", rs.getInt(1), rs.getInt(2),
											rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
									amount = rs.getInt(5);
								}

								UserDOlmpl userdao1 = new UserDOlmpl();
								boolean b1 = userdao1.updateWallet(user1, amount);
								if (b1 == true) {
									System.out.println("Amount is deducted from wallet successfully");
								} else {
									System.out.println("Amount is not deducted (or) insufficent balance");
								}
							} else {
								System.out.println("request details are not updated");
							}

							break;

						case 3:
							int RequestId = 0;
							int n = 0;
							String category1 = null;
							String location1 = null;
							boolean b3 = false;
							do {
								System.out.println("enter the category");
								category1 = sc.nextLine();
								if (category1.isEmpty()) {
									System.out.println("category should not be empty");
								}
								if (!category1.matches("[a-zA-Z]+")) {
									System.out.println("category should not contains numbers");
								}
							} while (category1.isEmpty() || !category1.matches("[a-zA-Z]+"));
							do {
								System.out.println("enter the location");
								location1 = sc.nextLine();
								if (location1.isEmpty()) {
									System.out.println("location should not be empty");
								}
								if (!location1.matches("[a-zA-Z]+")) {
									System.out.println("location should not contains numbers");
								}
							} while (location1.isEmpty() || !location1.matches("[a-zA-Z]+"));

							// System.out.println("enter the email");
							// String email = sc.nextLine();
							UserDOlmpl userdao = new UserDOlmpl();
							int userId = userdao.findUser(user1.getUserEmail());
							System.out.println(userId);
							RequestDOlmpl requestdao1 = new RequestDOlmpl();
							RequestId = requestdao1.findRequestID(userId, category1, location1);
							if (RequestId != 0) {
								System.out.println("requestId found");
							} else {
								System.out.println("requestId not found");
							}
							RequestDOlmpl requestdao = new RequestDOlmpl();
							boolean b2 = requestdao.deleteRequest(RequestId);
							if (b2 == true) {
								System.out.println("Request is deleted successfully");
							} else {
								System.out.println("Request is not deleted");
							}
							CategoryDOlmpl categorydao = new CategoryDOlmpl();
							CategoryDetails cd = categorydao.findAmount(category1);
							// System.out.println(amount1);
							UserDOlmpl userdao3 = new UserDOlmpl();
							b3 = userdao3.refundWallet(user1, cd);
							if (b3 == true) {
								System.out.println("amount is refunded to the user wallet");
							} else {
								System.out.println("amount is not refunded");
							}

							break;

						case 4:
							System.out.println("how much you want to recharge");
							Double walletAmount = Double.parseDouble(sc.nextLine());
							user1.setWallet(user1.getWallet() + walletAmount);
							UserDOlmpl userdao1 = new UserDOlmpl();
							boolean b1 = userdao1.rechargeWallet(user1);
							if (b1 == true) {
								System.out.println("wallet recharge successfully");
							} else {
								System.out.println("wallet is not updated");
							}
							break;
						}
					} else {
						System.out.println("invalid username and password");
					}

				} while (user1 == null);
				break;

			}
			break;
		case 3:
			System.out.println("\n1 Employee validation \n2 viewRequest");
			int c = Integer.parseInt(sc.nextLine());
			switch (c) {
			case 1:
				String email = null;
				String password = null;
				Employee employee = null;
				do {
					System.out.println("login");

					do {
						System.out.println("enter the email");
						email = sc.nextLine();
						if (!email.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]{2,3}")) {
							System.out.println("email should be in abc@gamil.com");
						}
						if (email.isEmpty()) {
							System.out.println("cant be empty");
						}
					} while (!email.matches("[a-z][a-z0-9]+[@][a-z]+[.][a-z]{2,3}") || email.isEmpty());
					do {
						System.out.println("enter the password");
						password = sc.nextLine();
						if (!password.matches("[a-zA-Z0-9@#$_&%]{8,15}")) {
							System.out.println("password doesnot matches the condition");
						}
						if (password.isEmpty()) {
							System.out.println("password should not be empty");
						}
					} while (!password.matches("[a-zA-Z0-9@#$_&%]{8,15}") || password.isEmpty());
					empdao = new EmployeeDOlmpl();
					employee = empdao.validation(email, password);

					if (employee != null) {
						System.out.println("welcome" + " " + employee.getEmpName());
					} else {
						System.out.println("invalid email or password");
					}
				} while (employee == null);
			case 2:
				RequestDOlmpl requestdao = new RequestDOlmpl();
				List<Request> listemployee = requestdao.showRequest();
				for (int k = 0; k < listemployee.size(); k++) {
					System.out.println(listemployee.get(k));
				}
				break;
			}

		}
	}
}
