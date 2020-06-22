<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
<%= (String)session.getAttribute("username") == null ? "" : "Welcome " + (String)session.getAttribute("username") %>
<br/>
<a href="/ASM2/logout">logout</a>
</p>
</body>
</html>