<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<title>게시판 상세보기</title>
<style>
	.outer table {
		border: 1px solid;
		border-collapse: collapse;
	}
	.outer tr, .outer td {
		border: 1px solid;
	}
</style>

</head>
<body>
	<div class="outer">
		<h2>게시판 상세보기</h2>
		
		<table align="center">
			<tr>
				<td width="100px;">글번호</td>
				<td width="400px;">${b.boardNo}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${b.boardTitle}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${b.boardWriter}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${b.count}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${b.createDate}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${b.boardContent}</td>
			</tr>
		</table>
		<br>
		<table align="center">
			<c:choose>
				<c:when test="${ empty loginUser }">
					<tr>
						<td>댓글 작성</td>
						<td><textarea row="3" cols="50" readonly>로그인 후 이용가능한 서비스 입니다.</textarea></td>
						<td><input type="button" value="댓글작성" disabled></td>
					</tr>
				</c:when>
				<c:otherwise>
					<form id="rFrm">
						<tr>
							<td>댓글 작성</td>
							<td><textarea row="3" cols="50" name="content"></textarea></td>
							<td><input type="button" value="댓글작성" id="replyInsert"></td>
							<input type="hidden" name="bno" value="${b.boardNo}">
							<input type="hidden" name="writer" value="${loginUser.userId}">
						</tr>
					</form>
				</c:otherwise>
			</c:choose>
			<tr>
				<td colspan="3" style="text-align:center">댓글 : ${reply.size()}</td>
			</tr>
			<tbody id="replyList">
				<c:forEach var="r" items="${reply}">
					<tr>
						<td>${r.replyWriter}</td>
						<td>${r.replyContent}</td>
						<td>${r.createDate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script>
		$(() => {
			$('#replyInsert').click(function() {
				// serialize() : 폼안의 input, select, textarea등의 value의 값을 간단하게 표준 url인코딩 형태 문자열로 만들어줌
				// content=내용&id=값&writer=값
				let rdata = $('#rFrm').serialize();
				$.ajax({
					url : 'rinsert.bo',
					data : rdata,
					success: function(result) {
						console.log(result);
						if(result > 0) {
							replyList();
						}
					},
					error: function() {
						console.log("댓글달기 통신 실패");
					}
				})
			})
			
			function replyList() {
				$.ajax ({
					url : "detail.bo",
					data : {bno : ${b.boardNo}},
					type: "post",
					success : function(result) {
						console.log(result);
						let list = "";
						$.each(result, function(index, value) {
							list += "<tr>"
									+ "<td>"+ value.replyWriter +"</td>"
									+ "<td>"+ value.replyContent + "</td>"
									+ "<td>"+ value.createDate + "</td>"
								  + "</tr>";
						})
						$('#replyList').html(list);
					},
					error : function() {
						console.log('댓글등록 후 리스트 목록 통신 실패');
					}
				})
			}
		})
	</script>
</body>
</html>