package com.cleaningmanagement.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cleaningmanagement.daoimpl.RequestDAOImpl;
import com.cleaningmanagement.model.Request;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String search=request.getParameter("search");
		
		RequestDAOImpl requestdao=new RequestDAOImpl();
		List<Request> requestlist=requestdao.showRequest(search);
//		List<Request> list=new ArrayList<Request>();
		for(int i=0;i<requestlist.size();i++)
		{
			Request req=requestlist.get(i);
			
		 if(req.getLocation().equalsIgnoreCase(search))
		 {
			 requestlist.add(req);
		 }
		 else if(req.getCatogories().equalsIgnoreCase(search))
		 {
			 requestlist.add(req);
		 }
		 else if(req.getEmployeestatus().equalsIgnoreCase(search)) 
		 {
			 requestlist.add(req);
		 }
		 else if(req.getStatus().equalsIgnoreCase(search))
		 {
			 requestlist.add(req);
		 }
		 else if(req.getUser().getUserName().equalsIgnoreCase(search))
		 {
			 requestlist.add(req);
		 }
//		 for(int j=0;j<list.size();j++)
//		 {
//			 Request requestdetails=list.get(j);
//		 }
		 
		}
		HttpSession session=request.getSession();
		session.setAttribute("list", requestlist);
		response.sendRedirect("SearchLocation.jsp");
	}

	

}
