package com.cleaningmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cleaningmanagement.daoimpl.UserDAOImpl;
import com.cleaningmanagement.model.User;


/**
 * Servlet implementation class RechargeWalletController
 */
@WebServlet("/RechargeWalletController")
public class RechargeWalletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeWalletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Double wallet=Double.parseDouble(request.getParameter("amount"));
		PrintWriter pw=response.getWriter();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("CurrentUser");
		user.setWallet(user.getWallet() + wallet);
		UserDAOImpl userdao1 = new UserDAOImpl();
		boolean b1 = userdao1.rechargeWallet(user);
		if (b1 == true) {
			System.out.println("wallet recharge successfully");
		}
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
