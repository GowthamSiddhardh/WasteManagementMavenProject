package com.cleaningmanagement.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cleaningmanagement.daoimpl.AdminDAOImpl;
import com.cleaningmanagement.exception.FoundException;

/**
 * Servlet implementation class UpdateRequestStatusController
 */
@WebServlet("/UpdateRequestStatus")
public class UpdateRequestStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRequestStatusController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
		HttpSession session=request.getSession();
		String EmployeeStatus=(String)session.getAttribute("empstatus");
		if(EmployeeStatus.equalsIgnoreCase("done") ) {
		String status=request.getParameter("requeststatus");
		int requestId=(int) session.getAttribute("reqId");
		AdminDAOImpl admindao=new AdminDAOImpl();
		int n=admindao.updateRequest(status, requestId);
		if(n>0)
		{
			response.sendRedirect("viewrequest.jsp");
		}
		}
		else
		{
			throw new FoundException();
		}
		}catch(FoundException e)
		{
			HttpSession session=request.getSession();
			session.setAttribute("status", e.getMessage5());
			response.sendRedirect("viewrequest.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
