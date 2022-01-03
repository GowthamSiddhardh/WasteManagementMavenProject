package com.cleaningmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cleaningmanagement.daoimpl.EmployeeDAOImpl;
import com.cleaningmanagement.daoimpl.RequestDAOImpl;
import com.cleaningmanagement.daoimpl.UserDAOImpl;
import com.cleaningmanagement.model.Employee;
import com.cleaningmanagement.model.Request;
import com.cleaningmanagement.model.User;



/**
 * Servlet implementation class RasieRequestController
 */
@WebServlet("/RasieRequestController")
public class RasieRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RasieRequestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String category=request.getParameter("category");
		String location=request.getParameter("location");
		PrintWriter pw=response.getWriter();
		pw.write("CATEGORY"+category);
		pw.write("LOCATION"+location);
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("CurrentUser");
		Employee employee=null;
		Request req=null;
		System.out.println(location);
		EmployeeDAOImpl empDao = new EmployeeDAOImpl();
	    employee = empDao.findEmployee(location);
		req = new Request(user, employee, category, location);
		RequestDAOImpl rd = new RequestDAOImpl();
		boolean b = rd.insertRequestDetails(req);
		
		if(b==true)
		{
			response.sendRedirect("showbill.jsp");
			System.out.println("inserted");
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
