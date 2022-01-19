package com.cleaningmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cleaningmanagement.daoimpl.CategoryDAOImpl;
import com.cleaningmanagement.daoimpl.EmployeeDAOImpl;
import com.cleaningmanagement.daoimpl.RequestDAOImpl;
import com.cleaningmanagement.daoimpl.UserDAOImpl;

import com.cleaningmanagement.exception.FoundException;
import com.cleaningmanagement.model.CategoryDetails;
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
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
		UserDAOImpl userdao1=new UserDAOImpl();
		List<User> userlist=userdao1.showUser();
		for(User user1:userlist)
		{
			if(user1.getUserEmail().equalsIgnoreCase(user.getUserEmail()))
			{
				user=user1;
			}
		}
		EmployeeDAOImpl empDao = new EmployeeDAOImpl();
	    employee = empDao.findEmployee(location);

	    if(employee!=null && employee.getStatus().equals("active"))
	    {
	    Date sysDate=new Date(); 
		req = new Request(user, employee, category, location,sysDate);
	    }
	    else
	    {
	    	throw new FoundException();
	    	
	    }
	    CategoryDAOImpl categorydao=new CategoryDAOImpl();
		CategoryDetails cd=categorydao.findAmount(category);
		try {
		if(user.getWallet()>cd.getAmount())
		{
		RequestDAOImpl rd = new RequestDAOImpl();
		boolean b = rd.insertRequestDetails(req);
		
		if(b)
		{
			response.sendRedirect("showbill.jsp");
			//System.out.println("inserted");
		}
		}
		else
		{
			throw new FoundException();
		}
		}catch(FoundException e) {
			HttpSession session1=request.getSession();
			session1.setAttribute("insufficient", e.getMessage2());
			response.sendRedirect("raiserequest.jsp");
			
		}
		}catch(FoundException e)
		{   
			HttpSession session1=request.getSession();
			session1.setAttribute("notfound", e.getMessage());
			
			response.sendRedirect("raiserequest.jsp");
			
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
