package com.sainath.hospital.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Patientservlet
 */
@WebServlet("/Patientservlet")
public class Patientservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private patientdbUtil PatientdbUtil;
    @Resource(name="jdbc/sainath_hospital")
    private DataSource datasource;
   

	@Override
	public void init() throws ServletException {

		super.init();
		try{
		PatientdbUtil = new patientdbUtil(datasource);}
		catch(Exception ex){throw new ServletException(ex);}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String thecommand = request.getParameter("register");
			if(thecommand.equals("register")){
			addPatient(request,response);}
			else if(thecommand.equals("search")){
				listPatients(request,response);
			}
			else if(thecommand.equals("load")){
				try {
					updatePatient(request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(thecommand.equals("update")){
				try {
					doupdate(request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if(thecommand.equals("login")){
				try {
					login(request,response);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if(thecommand.equals("pullnew")){

				   RequestDispatcher dispatcher = request.getRequestDispatcher("/patientregistration.jsp");
					dispatcher.forward(request, response);
			}
			
			else if(thecommand.equals("pullresults")){
				try {
					returnsearch(request,response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void returnsearch(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String searchfirst = request.getParameter("searchfirstname");
		String searchlast = request.getParameter("searchlastname");
		String searchstartdate = request.getParameter("startdate");
		String searchenddate = request.getParameter("enddate");
		
		List<patient> searchresults = PatientdbUtil.givesearch(searchfirst,searchlast,searchstartdate,searchenddate);
		request.setAttribute("searchresults",searchresults);
		
		if(searchresults.size() == 0){
			boolean flags = false;
			request.setAttribute("norecords",flags);
			listPatients(request,response);
		}
		
		else{RequestDispatcher dispatcher = request.getRequestDispatcher("/searchresults.jsp");
		dispatcher.forward(request, response);}
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		Employee loginemployee = new Employee(userName,password);
		boolean flag = PatientdbUtil.login(loginemployee);
		
		if(flag == true){
			listPatients(request,response);
			/*RequestDispatcher dispatcher = request.getRequestDispatcher("/searchpage.jsp");
			dispatcher.forward(request, response);}*/
		}
		
		else{
			request.setAttribute("theerror", flag);
	     RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);}
		
	}

	private void doupdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        String patientvisit = request.getParameter("Visitid");
	       long SerialNumber = Long.parseLong(patientvisit);
		   String FirstName = request.getParameter("firstname");
		   String LastName = request.getParameter("lastname");
		   long Adhaar = Long.parseLong(request.getParameter("adhaar"));
		   String Address = request.getParameter("address");
		   String City = request.getParameter("city");
		   String State = request.getParameter("state");
		   int ZipCode = Integer.parseInt(request.getParameter("zipcode"));
		   long Phone = Long.parseLong(request.getParameter("phone"));
		   String Doctor = request.getParameter("doctor");
		   String Date = request.getParameter("date");
		   String Time = request.getParameter("time");
		   String Diagnosis = request.getParameter("diagnosis");
		   
		   patient thepatients = 
				   new 
				   patient(SerialNumber,FirstName,LastName,Adhaar,Address,
				   City,State,ZipCode,Phone,Doctor,Date,Time,Diagnosis);
		   
		   
		   PatientdbUtil.doupdatePatient(thepatients);
		   
		   listPatients(request,response);
		   
		   
	}

	private void updatePatient(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String thepatient = request.getParameter("patientnumber");
		patient currentpatient = PatientdbUtil.updatePatients(thepatient);
		request.setAttribute("updatepatients", currentpatient);
		RequestDispatcher dispatch= request.getRequestDispatcher("/Updatepatients.jsp");
		dispatch.forward(request, response);
	}

	private void listPatients(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		List<patient> recent100 = PatientdbUtil.listPatient();
		request.setAttribute("listpatients", recent100);
		RequestDispatcher dispatch= request.getRequestDispatcher("/searchpage.jsp");
		dispatch.forward(request, response);
	}

	private void addPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		   String FirstName = request.getParameter("firstname");
		   String LastName = request.getParameter("lastname");
		   long Adhaar = Long.parseLong(request.getParameter("adhaar"));
		   String Address = request.getParameter("address");
		   String City = request.getParameter("city");
		   String State = request.getParameter("state");
		   int ZipCode = Integer.parseInt(request.getParameter("zipcode"));
		   long Phone = Long.parseLong(request.getParameter("phone"));
		   String Doctor = request.getParameter("doctor");
		   String Date = request.getParameter("date");
		   String Time = request.getParameter("time");
		   String Diagnosis = request.getParameter("diagnosis");
		   
		   patient thepatient = 
				   new 
				   patient(FirstName,LastName,Adhaar, Address,
				   City,State,ZipCode,Phone,Doctor,Date,Time,Diagnosis);
		   
		   
		   PatientdbUtil.addPatient(thepatient);
		   
		   
		   /*RequestDispatcher dispatcher = request.getRequestDispatcher("/searchpage.jsp");
			dispatcher.forward(request, response);*/
		   listPatients(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     try {
					login(request,response);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
