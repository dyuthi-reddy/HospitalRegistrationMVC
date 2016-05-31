package com.sainath.hospital.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Resource(name="jdbc/sainath_hospital")
	private DataSource datasource;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		Connection myconn = null;
		Statement state = null;
		ResultSet rs = null;
		
		
		try{
		
	    myconn = datasource.getConnection();
		String sql = "select * from opregistration";
		state = myconn.createStatement();
		
		rs = state.executeQuery(sql);
		
		while(rs.next()){long uin = rs.getLong("Adhaar Number");out.println(uin);}
		
		}
		catch(Exception ex){ex.printStackTrace();}
		
	}

}
