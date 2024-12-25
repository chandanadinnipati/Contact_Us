package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.dao.RequestDao;
import com.dao.UserDao;
import com.model.Request;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Request> requests = RequestDao.fetchRequests();
		session.setAttribute("requests", requests);
		
		request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int requestId = Integer.parseInt(request.getParameter("requestId"));
		boolean isActive = Boolean.parseBoolean(request.getParameter("status"));
   
		RequestDao.changeStatus(requestId, isActive);
		response.sendRedirect(request.getRequestURI());
	} 
}
