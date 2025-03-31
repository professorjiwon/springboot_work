<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a {
		text-decoration: none;
		color:black;
		cursor: pointer;
	}
</style>
</head>
<body>
	<h1>Member JPA #02</h1>
	
	<a href="insert">데이터 추가</a><br><br>
	<a href=/selectAll>전체 조회</a><br><br>
	<a href=/select?id=1>개별 조회</a><br><br>
	<hr>
	
	<a href=/selectByName?name=더조은>개별 조회 - ByName</a><br><br>
	<a href=/selectByEmail?email=test2@test.com>개별 조회 - ByEmail</a><br><br>
	<a href=/selectByNameLike?name=김>개별 조회 - ByName Like</a><br><br>
	<a href=/selectByNameLikeNameDesc?name=김>개별 조회 - ByName Like Name Desc</a><br><br>
	<a href=/selectByNameLikeNameSort?name=김>개별 조회 - ByName Like Name Sort</a><br><br>
</body>
</html>






