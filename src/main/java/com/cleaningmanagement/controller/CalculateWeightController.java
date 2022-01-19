package com.cleaningmanagement.controller;

import java.io.IOException;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cleaningmanagement.daoimpl.RequestDAOImpl;

/**
 * Servlet implementation class CalculateWeightController
 */
@WebServlet("/CalculateWeight")
public class CalculateWeightController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculateWeightController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String location = request.getParameter("location");
			Date fromdate = sdf.parse(request.getParameter("fromdate"));
			Date todate = sdf.parse(request.getParameter("todate"));
			HttpSession session = request.getSession();
			session.setAttribute("location", location);
			session.setAttribute("fromdate", fromdate);
			session.setAttribute("todate", todate);
			response.sendRedirect("CalculateWeight.jsp");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
