<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exception Details</title>
</head>
<body>
<center>
<h2 style="color:red">Generalized Exception Handler</h2>
<hr>
Details of Exception
<hr>
${exception}
<a href="${pageContext.request.contextPath}/">Home</a>
</center>
</body>
</html>