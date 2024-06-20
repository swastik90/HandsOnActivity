<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Patient Details</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Add Patient Details</h2>
		<form:form modelAttribute="patientObj" method="GET"
			action="savePatient.html">
			<br>
			<table border="2">
				
				<tr>
					<th>Phone Number</th>
					<td><form:input path="phone_number" /></td>
				</tr>
				<tr>
					<th>Email Id</th>
					<td><form:input path="email" /></td>
				</tr>
			</table>
			<input type="submit" value="Register">
		</form:form>
	</center>
</body>
</html>