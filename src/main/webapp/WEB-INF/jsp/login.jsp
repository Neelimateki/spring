<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Tab</title>
</head>
<body>
${name}
	<h1>Please login</h1>
	<font color="red">${errorMessage}</font>
	<form action="/login.do" method="POST">
		Name : <input name="name" type="text" /></br> Password : <input
			name="password" type="password" /> ,</br> <input type="submit" />
	</form>

</body>
</html>