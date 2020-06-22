<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p style="color:red">
<%= (String)session.getAttribute("error") == null ? "" : (String)session.getAttribute("error") %>
</p>
<form action="/ASM2/login" method="post">
	<label>Username</label>
	<input type="text" name="username" placeholder="Enter Username"/>
	<br/>
	<label>Password</label>
	<input type="password" name="password" placeholder="Enter Password"/>
	<br/>
	<input type="checkbox" name="rememberMe" />
	<label>Remember Me</label>
	<input type="submit" value="Login" />
</form>
</body>
</html>