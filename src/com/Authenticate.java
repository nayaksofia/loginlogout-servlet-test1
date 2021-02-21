package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//Set the content type
	response.setContentType("text/html");
		
		
	//Get a reference to the Session
	 HttpSession theSession = request.getSession();
		
		
	// Get param values from the request
	String userName = request.getParameter("userName");
	String userPass = request.getParameter("userPass");
	
	
	if(userName.equalsIgnoreCase("Sofia") && userPass.equals("sf43")) {
		
		//Put the UserName into the session
		
		theSession.setAttribute("uName", userName);
		
	  // Redirect to the Dashboard
		
		response.sendRedirect("dashboard");
		
	}else {
		
		// Redirect back to the index page
		
		
	    // Type:1
		response.sendRedirect("index.html");
		
		
		/*  //Type-2: Using RequestDispatcher
		 * 
		 RequestDispatcher rd =null;
		 PrintWriter out = response.getWriter();
		 out.println("Invalid Username or Password" + "<br> <br>");
		 rd = request.getRequestDispatcher("index.html");
		 rd.include(request, response);
		 * 
		 * */
	}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
