package com.cleaningmanagement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cleaningmanagement.daoimpl.CategoryDAOImpl;
import com.cleaningmanagement.model.CategoryDetails;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/CategoryController")
public class AddCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCategoryController() {
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
		int weight = Integer.parseInt(request.getParameter("weight"));
		String category = request.getParameter("category");
		int amount = Integer.parseInt(request.getParameter("amount"));
		PrintWriter pw = response.getWriter();
		pw.write(weight);
		pw.write(category);
		pw.write(amount);

		CategoryDetails c1 = new CategoryDetails(weight, category, amount);
		CategoryDAOImpl categorydao = new CategoryDAOImpl();
		int k = categorydao.insertCategoryDetails(c1);
		if (k > 0) {
			response.sendRedirect("AddedListCategory.jsp");
		} else {
			response.sendRedirect("category.jsp");
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
