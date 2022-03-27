package com.jahanvi.registraion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String umail = request.getParameter("username");
	     String upwd = request.getParameter("password");
	     HttpSession session = request.getSession();
	     RequestDispatcher dispatcher = null;
	     Connection con = null;
	     try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	    	  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","admin");
	    	 PreparedStatement pst = con.prepareStatement("select * from students where usermail=? and password =?");
	    	 pst.setString(1,umail);
	    	 pst.setString(2,upwd);
	    	 
	    	ResultSet rs = pst.executeQuery();
	    	
	    	if(rs.next()){
	    		session.setAttribute("name", rs.getString("username"));
	    		dispatcher = request.getRequestDispatcher("index.jsp");
	    	}else {
	    		request.setAttribute("status", "failed");
	    		dispatcher = request.getRequestDispatcher("login.jsp");
	    	}
	    	dispatcher.forward(request, response);
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }finally {
	    	 try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	     }
	     
	}

}
