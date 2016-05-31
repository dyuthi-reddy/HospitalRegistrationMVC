package com.sainath.hospital.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class patientdbUtil {
private DataSource datasource;

public patientdbUtil(DataSource thedatasource) {

	datasource = thedatasource;
}

public void addPatient(patient thepatient) throws SQLException {
       
	Connection myconn = null;
	PreparedStatement ps = null;
	
	myconn = datasource.getConnection();
	
	try{
		myconn = datasource.getConnection();

	String sql = "INSERT INTO opregistration "
	+"(FirstName, LastName, AdhaarNumber, Address, City, State, ZipCode, Phone, Diagnosis, ConsultingDoctor, Dates, Times) "
	+"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	
	ps = myconn.prepareStatement(sql);
	
	ps.setString(1, thepatient.getFirstName());
	ps.setString(2, thepatient.getLastName());
	ps.setLong(3, thepatient.getAdhaarNumber());
	ps.setString(4, thepatient.getAddress());
	ps.setString(5, thepatient.getCity());
	ps.setString(6, thepatient.getState());
	ps.setInt(7, thepatient.getZipCode());
	ps.setLong(8, thepatient.getPhone());
	ps.setString(9, thepatient.getDiagnosis());
	ps.setString(10, thepatient.getDoctor());
	ps.setString(11, thepatient.getDate());
	ps.setString(12, thepatient.getTime());
	
	
	ps.execute();
	}
	
	catch(Exception ex){throw new SQLException(ex);}
}

public List<patient> listPatient() throws SQLException {
	Connection myconn = null;
	Statement ps = null;
	ResultSet rs = null;
	
	List<patient> patientlist = new ArrayList<patient>();
	
	try{
		myconn = datasource.getConnection();
		String sql = "select * from opregistration order by SerialNumber DESC LIMIT 100";
		
		ps = myconn.createStatement();
		rs = ps.executeQuery(sql);
		
		while(rs.next()){
			long SerialNumber = rs.getLong("SerialNumber");
			   String FirstName = rs.getString("FirstName");
			   String LastName = rs.getString("Lastname");
			   String Address = rs.getString("Address");
			   String City = rs.getString("City");
			   long Phone = rs.getLong("Phone");
			   String Doctor = rs.getString("ConsultingDoctor");
			   String Date = rs.getString("Dates");
			   String Time = rs.getString("Times");	
			   
			   patient mypatient = new patient(SerialNumber,FirstName,LastName,Address,City,Phone,Doctor,Date,Time);
			   patientlist.add(mypatient);
		}
		
		
	}
	catch(Exception ex){throw new SQLException(ex);}
	return patientlist;
}

public patient updatePatients(String thepatient) throws Exception {
    Connection myconn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    patient updatepatient = null;
    long serialNumber;
    try {
    	serialNumber = Integer.parseInt(thepatient);
		myconn = datasource.getConnection();
		String sql = "select * from opregistration where SerialNumber = ?";
		
		
		ps = myconn.prepareStatement(sql);
		ps.setLong(1, serialNumber);
		rs = ps.executeQuery();
		
		if(rs.next()){
			 long SerialNumber = rs.getLong("SerialNumber");
			   String FirstName = rs.getString("FirstName");
			   String LastName = rs.getString("Lastname");
			   long AdhaarNumber = rs.getLong("AdhaarNumber");
			   String Address = rs.getString("Address");
			   String City = rs.getString("City");
			   String state = rs.getString("State");
				int ZipCode = rs.getInt("ZipCode");
			   long Phone = rs.getLong("Phone");
			   String Doctor = rs.getString("ConsultingDoctor");
			   String Date = rs.getString("Dates");
			   String Time = rs.getString("Times");
			   String Diagnosis = rs.getString("Diagnosis");
			   
			  updatepatient = new patient(SerialNumber,FirstName, LastName, AdhaarNumber, Address, City, state, ZipCode, Phone, Doctor, Date, Time,Diagnosis);
		}
		else{throw new Exception("This Patient with may be unavailable");}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	return updatepatient;
}

public void doupdatePatient(patient thepatients) throws Exception {
	Connection myconn = null;
	PreparedStatement ps = null;
	
	
	try{
		myconn = datasource.getConnection();
		String sql = "UPDATE opregistration "+ "SET FirstName=?, LastName=?, AdhaarNumber=?, Address=?, City=?, State=?, ZipCode=?, Phone=?, Diagnosis=?, ConsultingDoctor=?, Dates=?, Times=? "
		              + "WHERE SerialNumber=?";
		
		ps = myconn.prepareStatement(sql);
		
		ps.setString(1, thepatients.getFirstName());
		ps.setString(2, thepatients.getLastName());
		ps.setLong(3, thepatients.getAdhaarNumber());
		ps.setString(4, thepatients.getAddress());
		ps.setString(5, thepatients.getCity());
		ps.setString(6, thepatients.getState());
		ps.setInt(7, thepatients.getZipCode());
		ps.setLong(8, thepatients.getPhone());
		ps.setString(9, thepatients.getDiagnosis());
		ps.setString(10, thepatients.getDoctor());
		ps.setString(11, thepatients.getDate());
		ps.setString(12, thepatients.getTime());
		ps.setLong(13, thepatients.getSerialNumber());
		
		ps.execute();
	}
	
	
	catch(Exception ex){throw new SQLException(ex);}
	
}

public boolean login(Employee loginemployee) throws Exception{
	// TODO Auto-generated method stub
	Connection myconn = null;
	Statement ps = null;
	ResultSet rs = null;
	boolean flag = false;
	
	try{
		myconn = datasource.getConnection();
		String sql = "select * from employee";
		
		ps = myconn.createStatement();
		
		rs = ps.executeQuery(sql);
		
		while(rs.next()){
		String userName = rs.getString("UserName");
		String password = rs.getString("Password");
		
		if(userName.equals(loginemployee.getUserName()) && password.equals(loginemployee.getPassword()))
		{flag = true;break;}
		else{flag = false;}
		
		}	
	}
	catch(Exception ex){throw new SQLException(ex);}
	return flag;
	
	
}

public List<patient> givesearch(String searchfirst,String searchlast,String searchstartdate,String searchenddate) throws SQLException {
	List<patient> result = new ArrayList<patient>();
	Connection myconn = null;
	Statement ps = null;
	ResultSet rs = null;
	
	try{
		myconn = datasource.getConnection();
		StringBuilder sb = new StringBuilder("select * from opregistration ");
		sb.append("where ");
		if(!searchfirst.equals("")){ sb.append("FirstName = '").append(searchfirst).append("'");}
		if(!searchlast.equals("")){sb.append(" ");sb.append("OR");sb.append(" ");sb.append("LastName = '").append(searchlast).append("'").append(";");}
	   /*if(!searchstartdate.equals("")){sb.append("Dates=searchstartdate");}
		"""if(!searchenddate.equals("")){sb.append("Dates=searchenddate");}*/
		
		String sql = sb.toString();
		
		
		ps = myconn.createStatement();
		rs = ps.executeQuery(sql);
		
		while(rs.next()){
			   long SerialNumber = rs.getLong("SerialNumber");
			   String FirstName = rs.getString("FirstName");
			   String LastName = rs.getString("Lastname");
			   String Address = rs.getString("Address");
			   String City = rs.getString("City");
			   long Phone = rs.getLong("Phone");
			   String Doctor = rs.getString("ConsultingDoctor");
			   String Date = rs.getString("Dates");
			   String Time = rs.getString("Times");	
			   
			   patient mypatients = new patient(SerialNumber,FirstName,LastName,Address,City,Phone,Doctor,Date,Time);
			   result.add(mypatients);
			   System.out.println(result.size());
			   System.out.println(sql);
			
		}
	}
	catch(Exception ex){throw new SQLException(ex);}
	
	return result;
}


}
