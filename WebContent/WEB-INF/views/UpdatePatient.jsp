<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Patient</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
</head>
<body>
	<center>
		<h2>Update Patient Details</h2>
		<form:form modelAttribute="patientObj" method="POST"
			action="LoadUpdatePatient2.html">
			<br>
			<table border="2">
				<tr>
					<th>Patient ID</th>
					<td><form:input path="user_id" onchange="submit()" /></td>

				</tr>
			</table>
		</form:form>
		<c:if test="${not empty patientObj2 && message==null }">
			<h3>Below are the details of Patient</h3>
			<form:form modelAttribute="patientObj2" method="POST"
				action="UpdatePatient.html">
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
				<input type="submit" value="Update">
			</form:form>
		</c:if>
	</center>
</body>
</html>