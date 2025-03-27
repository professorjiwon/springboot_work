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
	<h1 align="center">게 시 판</h1>
	<p align="right">총 레코드수 : ${ totalRecord }</p>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>삭제</th>
		</tr>

		<c:forEach var="b" items="${list}">
			<tr>
				<td>${b.boardno}</td>
				<td><a href="detail?boardno=${b.boardno}">${b.title}</a></td>
				<td>${b.writer}</td>
				<td><button type="button" class="btn btn-outline-danger" onclick="location.href='delete?boardno=${b.boardno}'">삭제</button></td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<div align="right"><button type="button" class="btn btn-outline-info" onclick="location.href='writeForm'">글 작 성</button></div>
</body>
</html>