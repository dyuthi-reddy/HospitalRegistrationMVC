<%@ page import="java.util.*, com.sainath.hospital.jdbc.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Search and Edit page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
<script>
  $(function() {
    $( ".datepick" ).datepicker();
  });
 </script>

<style type="text/css">
 .topcorner{
   position:absolute;
   top:120px;
   right:0px;
   
    padding: 10px;
    border: 2px solid navy;
    margin: 25px;
  }
  
   .topbutton{
   position:absolute;
   top:100px;
   right:25px;
  
  }
  
</style>

</head>


<body background = "C:/Users/dyuthi/Documents/Coding/bg3.jpg">
<h1 align = "center">Sainath Hospital</h1>
<hr/>
<h2>Registered Patients</h2>
<form action = "Patientservlet" method = "GET" class = "topbutton">
<input type = "hidden" name = "register" value = "pullnew"/>
<input type = "submit" value = "Add New"/>
</form>
<table border="1">
<tr>
<th>First Name</th>
<th>Last Name</th>
<th>Address</th>
<th>City</th>
<th>Phone</th>
<th>Consulting Doctor</th>
<th>Date</th>
<th>Time</th>
<th>Action</th>
</tr>

<c:forEach var = "temppatient" items = "${listpatients}">
<c:url var= "tempLink" value = "Patientservlet">
<c:param name = "register" value = "load"/>
<c:param name = "patientnumber" value = "${temppatient.serialNumber}"/>
</c:url>

<tr>
<td>${temppatient.firstName}</td>
<td>${temppatient.lastName}</td>
<td>${temppatient.address}</td>
<td>${temppatient.city}</td>
<td>${temppatient.phone}</td>
<td>${temppatient.doctor}</td>
<td>${temppatient.date}</td>
<td>${temppatient.time}</td>
<td><a href="${tempLink}">update</a></td>
</tr>
</c:forEach>
</table>

<div class = "topcorner">
<form action = "Patientservlet" method = "GET" id = "searchform">

<table>
<tr>
<td>
<input type = "hidden" name = "register" value = "pullresults"/></td>
<td><br/></td>
</tr>
<tr>
<td><label>First Name:</label></td>
<td>
<input type = "text" name = "searchfirstname"/></td>
<td><label>Last Name:</label></td>
<td><input type = "text" name = "searchlastname"/></td></tr>

<!--<tr>
<td><label>Start Date:</label></td>
<td><input type = "text" name = "startdate" class="datepick"/></td>
<td><label>End Date:</label></td>
<td><input type = "text" name = "enddate" class="datepick"/></td></tr>
 -->

<tr>
<td><br/><br/></td>

<td><label></label></td>
<td><input type = "submit" value = "Search"/></td></tr>
</table>
</form>
</div>
<% 
if(request.getAttribute("norecords") != null)
{
if((boolean)request.getAttribute("norecords") == false){
	out.println("No matching records found");
}}%>
</body>
</html>