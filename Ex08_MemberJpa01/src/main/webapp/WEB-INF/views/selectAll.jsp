<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select All</title>
</head>
<body>
	<h1>Member JPA #01 - Select All</h1>
	
	<c:forEach var="m" items="${members}">
		아이디 : ${m.id}<br>
		이름 : ${m.username}<br>
		날짜 : ${m.createDate}<hr>
	</c:forEach>
</body>
</html>