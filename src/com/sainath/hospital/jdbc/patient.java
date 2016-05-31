package com.sainath.hospital.jdbc;

import java.sql.Date;
import java.util.*;

public class patient {
private long serialNumber;
private String firstName;
private String lastName;
private long adhaarNumber;
private String address;
private String city;
private String state;
private int zipCode;
private long phone;
private String doctor;
private String date;
private String time;
private String diagnosis;
public patient(long serialNumber,String firstName, String lastName, String address, String city, long phone,
		String doctor, String date, String time) {
	super();
	this.serialNumber = serialNumber;
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.city = city;
	this.phone = phone;
	this.doctor = doctor;
	this.date = date;
	this.time = time;
}

public patient(long serialNumber, String firstName, String lastName, long adhaarNumber, String address, String city,
		String state, int zipCode, long phone, String doctor, String date, String time, String diagnosis) {
	super();
	this.serialNumber = serialNumber;
	this.firstName = firstName;
	this.lastName = lastName;
	this.adhaarNumber = adhaarNumber;
	this.address = address;
	this.city = city;
	this.state = state;
	this.zipCode = zipCode;
	this.phone = phone;
	this.doctor = doctor;
	this.date = date;
	this.time = time;
	this.diagnosis = diagnosis;
}

public patient(String firstName, String lastName, long adhaarNumber, String address, String city, String state,
		int zipCode, long phone, String doctor, String date, String time, String diagnosis) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.adhaarNumber = adhaarNumber;
	this.address = address;
	this.city = city;
	this.state = state;
	this.zipCode = zipCode;
	this.phone = phone;
	this.doctor = doctor;
	this.date = date;
	this.time = time;
	this.diagnosis = diagnosis;
}

public long getSerialNumber() {
	return serialNumber;
}
public void setSerialNumber(long serialNumber) {
	this.serialNumber = serialNumber;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public long getAdhaarNumber() {
	return adhaarNumber;
}
public void setAdhaarNumber(long adhaarNumber) {
	this.adhaarNumber = adhaarNumber;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getZipCode() {
	return zipCode;
}
public void setZipCode(int zipCode) {
	this.zipCode = zipCode;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getDoctor() {
	return doctor;
}
public void setDoctor(String doctor) {
	this.doctor = doctor;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getDiagnosis() {
	return diagnosis;
}
public void setDiagnosis(String diagnosis) {
	this.diagnosis = diagnosis;
}


}
