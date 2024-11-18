package com.techcarver;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/RegistrationForm")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Step1: Get Values From JSP using request object

		String userName = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String gender = request.getParameter("gender1");
		String city = request.getParameter("city");

		// Step2: Database Connectivity [Add MySQL Connector JAR into Project BuildPath]

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tc_data", "root",
					"@Vaman88");
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("insert into register values (?,?,?,?,?)");
//			preparedStatement.setString(1, userName);
//			preparedStatement.setString(2, email);
//			preparedStatement.setString(3, pass);
//			preparedStatement.setString(4, gender);
//			preparedStatement.setString(5, city);
			
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO register (name,email, password, gender, city) VALUES ('"+userName+"', '"+email+"', '"+pass+"', '"+gender+"', '"+city+"')");

			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<h3 style='color:green'> User Registerd... </h3>");
				out.print("<script> alert('record saved ')</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				rd.include(request, response);
			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("<h3 style='color:red'> User Not Registerd... </h3>");
				out.print("<script> alert('record not saved ')</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				rd.include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<h3 style='color:red'> User Not Registerd... </h3>");
			out.print("<script> alert('record not saved ')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			rd.include(request, response);
		}
	}
}
