<html>
<head>
<title>Out Patient Registration</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
<script>
  $(function() {
    $( ".datepicker" ).datepicker();
  });
 </script>
</head>

<body background = "C:/Users/dyuthi/Documents/Coding/bg3.jpg">
<div>
<h1 align = "center">Out Patient Registration</h1>
</div>
<hr/>

<form action = "Patientservlet" method = "GET" id = "regform" >
<table>
<tr><td><h3><i>Personal Details</i></h3><hr/></td><tr/>
<tr>
<td><input type = "hidden" name = "register" value = "register"/></td>
</tr>
<tr><td><label>First Name:</label></td>
<td><input type = "text" name = "firstname"/></td>
</tr>

<tr><td><label>Last Name:</label></td>
<td><input type = "text" name = "lastname"/></td>
</tr>

<tr>
<td><label>Adhaar Number:</label></td>
<td><input type = "text" name = "adhaar"/></td>
</tr>

<tr>
<td><label>Address:</label></td>
<td><input type = "text" name = "address"/></td>
</tr>

<tr>
<td><label>City:</label></td>
<td><input type = "text" name = "city"/></td>
</tr>

<tr>
<td><label>State:</label></td>
<td><input type = "text" name = "state"/></td>
</tr>

<tr>
<td><label>Zip Code:</label></td>
<td><input type = "text" name = "zipcode"/></td>
</tr>

<tr>
<td><label>Phone:</label></td>
<td><input type = "text" name = "phone"/></td>
</tr>

<tr>
<td><label>Consulting Doctor:</label></td>
<td><input type = "text" name = "doctor"/></td>
</tr>

<tr>
<td><label>Date:</label></td>
<td><input type = "text" name = "date" class="datepicker"/></td>
</tr>

<tr>
<td><label>Time:</label></td>
<td><input type = "text" name = "time"/></td>
</tr>

<tr><td><br/></td><tr/>

<tr><td><h3><i>Diagnosis</i></h3><hr/></td><tr/>

 
</table>

<table>
 
 <tr><td><textarea rows="5" cols="32" name = "diagnosis">
Enter your Diagnosis here
</textarea><td/> <tr/>

<tr> 
<td><br/><input type = "submit" value = "Submit"/></td>
</tr>
</table>
</form>

<!--  <div class = "topcorner">
<form action = "Patientservlet" method = "GET" id = "searchform">

<table>
<tr>
<td>
<input type = "hidden" name = "register" value = "search"/></td>
<td><br/></td>
</tr>
<tr>
<td><label>First Name:</label></td>
<td>
<input type = "text" name = "searchfirstname"/></td>
<td><label>Last Name:</label></td>
<td><input type = "text" name = "searchlastname"/></td></tr>

<tr>
<td><label>Start Date:</label></td>
<td><input type = "text" name = "startdate" class="datepicker"/></td>
<td><label>End Date:</label></td>
<td><input type = "text" name = "enddate" class="datepicker"/></td></tr>
<tr>
<td><br/><br/></td>

<td><label></label></td>
<td><input type = "submit" value = "Search"/></td></tr>
</table>
</form>
</div> -->

</body>
</html>