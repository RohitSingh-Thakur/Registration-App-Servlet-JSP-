package com.techcarver;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/Login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tc_data", "root",
					"@Vaman88");
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM register WHERE email=? AND password=?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, pass);
			ResultSet resultSet = preparedStatement.executeQuery();
			// Using if because we are getting single row from table
			if (resultSet.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("name_key", resultSet.getString("name"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
				dispatcher.forward(request, response);

			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<h3 style='color.red'> Wrong Credentials... </h3>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<h3 style='color.red'> Wrong Credentials... </h3>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.include(request, response);
		}
	}
}
