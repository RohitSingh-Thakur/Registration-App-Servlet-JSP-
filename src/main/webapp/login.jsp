<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Login" method="post">
		Email: <input type="text" name="email" required="true" placeholder="Enter Email ID"><br><br>
		Password: <input type="password" name="pass" required="true" placeholder="Enter Password"><br><br>
		<input type="submit" value="Login">&nbsp; 
		
		<a href="register.jsp"> Sign Up</a>
	</form>
</body>
</html>