<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JPA Paging - Name Like Paging</h1>
	
	총 게시글의 갯수 : ${totalElements}<br><br>
	총 페이지 수 : ${totalPages}<br><br>
	한 페이지당 게시글 수 : ${size}<br><br>
	현재 페이지 : ${pageNumber}<br><br>
	현재 페이지의 글 수 : ${numberOfElements}<br><br>
	
</body>
</html>