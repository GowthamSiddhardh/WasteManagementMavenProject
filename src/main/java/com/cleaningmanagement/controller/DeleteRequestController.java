package com.cleaningmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cleaningmanagement.daoimpl.RequestDAOImpl;
import com.cleaningmanagement.daoimpl.UserDAOImpl;
import com.cleaningmanagement.model.User;

/**
 * Servlet implementation class DeleteRequestController
 */
@WebServlet("/Deleteserv")
public class DeleteRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("CurrentUser");
		int uid = Integer.parseInt(request.getParameter("rid").toString());
		String category = request.getParameter("cat");
		String loc = request.getParameter("loc");
		int Amount=Integer.parseInt(request.getParameter("amount"));
		System.out.println(category);
		System.out.println(loc);
		System.out.println(uid);
		RequestDAOImpl requestdao=new RequestDAOImpl();
		int RequestId=requestdao.findRequestID(uid, category, loc);
		boolean b=requestdao.deleteRequest(RequestId);
		if(b==true)
		{   
			UserDAOImpl userdao=new UserDAOImpl();
			userdao.refundWallet(user, Amount);
			response.sendRedirect("RefundMessage.jsp");
		}
		
	}

	

}
