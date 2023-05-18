package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String id = request.getParameter("id");
		long id1 = Long.parseLong(id);
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String age = request.getParameter("age");
		int age1 = Integer.parseInt(age);
		String gender = request.getParameter("gender");
		String 	username= request.getParameter("mail");
		String password = request.getParameter("pass");
		String phone= request.getParameter("phone");
		long phoneNumber = Long.parseLong(phone);
		String country = request.getParameter("country");

		
		RegisterDTO reg = new  RegisterDTO();
		
		reg.setId(id1);
		reg.setFirstname(firstname);
		reg.setLastname(lastname);
		reg.setAge(age1);
		reg.setGender(gender);
		reg.setUsername(username);
		reg.setPassword(password);
		reg.setPhonenumber(phoneNumber);
		reg.setCountry(country);
	
		try {
			int status  = RegisterDAO.saveRegDetails(reg);
			if(status == 1) {
				response.sendRedirect("index.html");
				pw.print(username);
			
			}
			else {
				pw.print("<html><body>");
				pw.print("<h1>Sorry, Please try after some time </h1>");
				pw.print("</body></html>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	
	}

}
