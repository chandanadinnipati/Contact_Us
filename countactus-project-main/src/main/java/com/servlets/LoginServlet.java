package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.*;

import com.dao.RequestDao;
import com.dao.UserDao;
import com.model.Request;
import com.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		User userData = new User();
		userData.setUserName(name);
		userData.setPassword(password);

		if (UserDao.isValidUser(userData)) {
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			
			response.sendRedirect("dashboard");
		} else {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
