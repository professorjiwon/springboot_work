<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	body {
		margin: auto;
		width: 800px;
	}
	a {
		text-decoration:none; color:black; cursor:pointer;
	}
</style>
</head>
<body>
	<br><br>
	<h1 align="center">상세보기</h1><br>
	작성자 : ${ board.writer }<br><br>
	제목 : ${ board.title }<br><br>
	내용 : ${ board.content }<br><br>
	<hr>
	
	<a href="list"><button type="button" class="btn btn-outline-secondary">목록보기</button></a>
</body>
</html>