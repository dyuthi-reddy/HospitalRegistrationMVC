package com.sainath.hospital.jdbc;

public class Employee {
private int employeeId;
private String userName;
private String password;
public Employee(int employeeId, String userName, String password) {
	super();
	this.employeeId = employeeId;
	this.userName = userName;
	this.password = password;
}
public Employee(String userName, String password) {
	super();
	this.userName = userName;
	this.password = password;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}
