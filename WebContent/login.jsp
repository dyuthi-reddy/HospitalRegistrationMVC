<%@ page import = "com.sainath.hospital.jdbc.*" %>


<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<link rel="stylesheet" href="/WebContent/css/hospital.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style>
.movedown{
   position:absolute;
   top:250px;
   left:800px;
   
   padding: 15px;
   border: 5px solid gray;
  }

.textbox { 
    background: transparent url(http://html-generator.weebly.com/files/theme/input-text-8.png) repeat-x; 
    border: 1px solid #999; 
    outline:0; 
    height:25px; 
    width: 220px; 
  } 
  </style>
<title>Login</title>

</head>
<% 
if(request.getAttribute("theerror") != null)
{
if((boolean)request.getAttribute("theerror") == false){
	out.println("UserName or Password is incorrect");
}}%>
<body background = "C:/Users/dyuthi/Documents/Coding/bg3.jpg">

<form action="Patientservlet" method = "POST" class = "movedown">

<div id = "loginheader" align = "center"><i><strong>SAINATH HOSPITAL EMPLOYEE LOGIN</strong></i><br/></div>
<div class = "loginpage" align = "center">
<table>
<tr>
<td><br/></td>
</tr>

<tr>
<td><label>User Name:</label></td>
<td><input type = "text" name = "username" class = "textbox" /></td>
</tr>


<tr>
<td><label>Password:</label></td>
<td><input type = "password" name = "password" class = "textbox"/></td>
</tr>

<tr><td><label></label></td></tr>

<tr>
<td><label></label></td>
<td><input type = "submit" value = "Login" class="btn btn-primary"/></td>
</tr>

</table>
</div>
</form>
</body>

</html>
