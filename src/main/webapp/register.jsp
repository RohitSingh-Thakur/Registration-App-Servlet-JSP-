<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="RegistrationForm" method="post">
		Name: <input type="text" name="name" required="true" placeholder="Enter User name"> <br><br>
		Email: <input type="text" name="email" required="true" placeholder="Enter Email ID"> <br><br> 
		Password: <input type="password" name="pass" required="true" placeholder="Enter Password"> <br><br> 
		Gender: <input type="radio" name="gender1" value="Male"> Male 
				<input type="radio" name="gender1" value=""> Female <br><br> 
		City: 	<select name="city">
					<option>Mumbai</option>
					<option>Banglore</option>
					<option>Pune</option>
					<option>Delhi</option>
				</select> <br><br> 
		<input type="submit" value="Register"> &nbsp; <a href="login.jsp"> Login</a>
	</form>
</body>
</html>