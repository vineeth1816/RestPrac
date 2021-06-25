<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="getEmp">
Enter id:<input type="text" name="empId">
<input type="submit" value="submit">
</form>
${emp.id}--${emp.name}--${emp.salary}
</body>
</html>