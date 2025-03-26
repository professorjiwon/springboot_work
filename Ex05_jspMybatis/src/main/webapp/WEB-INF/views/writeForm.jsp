<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<br><br>
	<h1>게시판 글 작성하기</h1>
	<form action="write" method="post">
		<table class="table">
			<tr>
				<th>작성자</th>
				<td><input name="writer"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea cols="100" rows="5" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" class="btn btn-outline-success">글쓰기</button>
					<a href="list"><button type="button" class="btn btn-outline-primary">목록</button></a>
				</td>
			</tr>
		</table>		
	</form>
</body>
</html>