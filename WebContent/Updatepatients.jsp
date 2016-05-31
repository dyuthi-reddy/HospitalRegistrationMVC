<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<style type="text/css">
 .topcorner{
   position:absolute;
   top:120px;
   right:50px;
  }
</style>
<title>Update Patient</title>
<!-- <link rel="stylesheet" type="text/css" href="css/hospital.css"> -->

</head>

<body background = "C:/Users/dyuthi/Documents/Coding/bg3.jpg">
<div>
<h1 align = "center">Out Patient Registration</h1>
</div>
<hr/>

<form action = "Patientservlet" method = "GET" id = "updateform" >
<table>
<tr><td><h3><i>Personal Details</i></h3><hr/></td><tr/>
<tr>
<td><input type = "hidden" name = "Visitid" value ="${updatepatients.serialNumber}"/></td></tr>
<tr><td><label>First Name:</label></td>
<td><input type = "text" name = "firstname"  value = "${updatepatients.firstName}"/></td>
</tr>

<tr><td><label>Last Name:</label></td>
<td><input type = "text" name = "lastname" value = "${updatepatients.lastName}"/>/></td>
</tr>

<tr>
<td><label>Adhaar Number:</label></td>
<td><input type = "text" name = "adhaar" value = "${updatepatients.adhaarNumber}"/>/></td>
</tr>

<tr>
<td><label>Address:</label></td>
<td><input type = "text" name = "address" value = "${updatepatients.address}"/></td>
</tr>

<tr>
<td><label>City:</label></td>
<td><input type = "text" name = "city" value = "${updatepatients.city}"/></td>
</tr>

<tr>
<td><label>State:</label></td>
<td><input type = "text" name = "state" value = "${updatepatients.state}" /></td>
</tr>

<tr>
<td><label>Zip Code:</label></td>
<td><input type = "text" name = "zipcode" value = "${updatepatients.zipCode}" /></td>
</tr>

<tr>
<td><label>Phone:</label></td>
<td><input type = "text" name = "phone" value = "${updatepatients.phone}" /></td>
</tr>

<tr>
<td><label>Consulting Doctor:</label></td>
<td><input type = "text" name = "doctor" value = "${updatepatients.doctor}"/></td>
</tr>

<tr>
<td><label>Date:</label></td>
<td><input type = "text" name = "date" value = "${updatepatients.date}"/></td>
</tr>

<tr>
<td><label>Time:</label></td>
<td><input type = "text" name = "time" value = "${updatepatients.time}"/></td>
</tr>

<tr><td><br/></td><tr/>

<tr><td><h3><i>Diagnosis</i></h3><hr/></td><tr/>

 
</table>

<table>
 
 <tr><td><textarea rows="5" cols="32" name = "diagnosis" >
 ${updatepatients.diagnosis}
</textarea><td/> <tr/>

<tr> 
<td><br/><input type = "submit" value = "Save" /></td>
<td><input type = "hidden" name = "register" value = "update"/></td>

</tr>
</table>

</form>

</body>
</html>