package com.cleaningmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cleaningmanagement.daoimpl.EmployeeDAOImpl;
import com.cleaningmanagement.model.Employee;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String emailId=request.getParameter("emailid");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String location=request.getParameter("location");
		PrintWriter pw=response.getWriter();
		pw.write(emailId);
		pw.write(name);
		pw.write(password);
		pw.write(location);
		boolean b=false;
		Employee emp = new Employee(emailId, name,password,location);
		EmployeeDAOImpl empdao = new EmployeeDAOImpl();
		b = empdao.insertEmpDatabase(emp);
		if (b == true) {
			System.out.println("registered successfully");
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
