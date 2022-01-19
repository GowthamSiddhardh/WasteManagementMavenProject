package com.cleaningmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cleaningmanagement.daoimpl.EmployeeDAOImpl;
import com.cleaningmanagement.model.Employee;

/**
 * Servlet implementation class ChangeEmployeeStatusController
 */
@WebServlet("/EmpstatusChange")
public class ChangeEmployeeStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String status=request.getParameter("status");
		System.out.println(status);
		HttpSession session=request.getSession();
		int requestId=(int)session.getAttribute("RequestId");
		EmployeeDAOImpl employeedao=new EmployeeDAOImpl();
		boolean b=employeedao.updateEmployeeStatus(status, requestId);
		if(b==true)
		{
			response.sendRedirect("showemployeesrequest.jsp");
		}
		
		
	}

	

}
