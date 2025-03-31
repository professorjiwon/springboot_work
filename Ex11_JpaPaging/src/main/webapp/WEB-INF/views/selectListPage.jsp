<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JPA Paging - Name Like Paging</h1>
	
	총 게시글의 갯수 : ${totalElements}<br>
	총 페이지 수 : ${totalPages}<br>
	한 페이지당 게시글 수 : ${size}<br>
	현재 페이지 : ${pageNumber}<br>
	현재 페이지의 글 수 : ${numberOfElements}<br>
	<hr>
	
	<c:forEach var="m" items="${members}">
		아이디 : ${m.id}<br>
		이름 : ${m.name}<br>
		이메일 : ${m.email}
		<hr>
	</c:forEach>
	
</body>
</html>