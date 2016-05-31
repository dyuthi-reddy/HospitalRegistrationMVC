<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>These are the matching records for your search</title></head>
<body background = "C:/Users/dyuthi/Documents/Coding/bg3.jpg">
<h1>Search Results</h1>
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

<c:forEach var = "temppatient" items = "${searchresults}">
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
</body>
</html>