package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.dao.RequestDao;
import com.model.Request;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/save")
public class ContactUsServlet extends HttpServlet {

	public void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
			throws IOException, ServletException {
		String name = servletRequest.getParameter("uname");
		String email = servletRequest.getParameter("email");
		String message = servletRequest.getParameter("message");

		Request request = new Request();
		request.setName(name);
		request.setEmail(email);
		request.setMessage(message);
		RequestDao.saveRequest(request);

		servletRequest.getRequestDispatcher("contactUs.jsp").forward(servletRequest, servletResponse);
	}

}
