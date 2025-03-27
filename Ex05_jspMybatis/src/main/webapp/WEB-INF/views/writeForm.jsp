<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1 align="center">게시판 글 작성하기</h1>
	<br>
	<form action="write" method="post"  class="row g-3">
		<label for="writer" class="col-sm-3 col-form-label">작성자</label>
		<div class="col-sm-7">
	    	<input type="text" class="form-control" id="writer" name="writer">
	    </div><br>
	    
	    <label for="title" class="col-sm-3 col-form-label">제목</label>
	    <div class="col-sm-7">
	    	<input type="text" class="form-control" id="title" name="title">
	    </div><br>
	    
	    <label for="content" class="col-sm-3 col-form-label">내용</label><br>
	    <div class="col-sm-7">
	    	<textarea rows="5" name="content" id="content" class="form-control"></textarea>
	    </div>
	    <div align="center">
			<button type="submit" class="btn btn-outline-success">글쓰기</button>&emsp;&emsp;&emsp;
			<a href="list"><button type="button" class="btn btn-outline-primary">목록</button></a>
		</div>		
	</form>
</body>
</html>