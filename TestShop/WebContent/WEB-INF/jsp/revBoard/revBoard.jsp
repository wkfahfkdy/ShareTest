<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>

<script>
	$(function(){
		CKEDITOR.replace('content',{
			filebrowserUploadUrl : '${pageContext.request.contextPath }/fileUpload',
			height : '600px',
			width : '800px'
		});
	});
	
	function revDelete(){
		
		let id = document.getElementsByName("id")[1].value;
		console.log(id);
		
		$.ajax({
			url : 'deleteServlet',
			data : {id},
			type : 'POST',
			success : function(resp){
				location.href = "revBoardList.do";
			},
			error : function(err){
				console.log(err);
			}
		});
	}
</script>

<div align = "center">

	<h3>후기 내용</h3>
	
	<form id = "frm" action = "revBoardUpdate.do" method = "POST">
		<table border = "1">
			<tr>
				<th>순번</th>
				<td><input type = "hidden" name = "id" value = "${revBoard.id }">${revBoard.id }</td>
				<th>작성일자</th>
				<td>${revBoard.regDate }</td>
				<th>작성자</th>
				<td>${revBoard.writer }</td>
				<th>조회수</th>
				<td>${revBoard.hit + 1 }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan = "7">
					<c:if test = "${id eq revBoard.writer || id eq 'admin' }">
						<input name = "title" type = "text" value = "${revBoard.title }">
					</c:if>
					<c:if test = "${id ne revBoard.writer && id ne 'admin' }">
						${revBoard.title }
					</c:if>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan = "7">
					<c:if test = "${id eq revBoard.writer || id eq 'admin' }">
						<textarea name = "content" rows = "6" cols = "90">${revBoard.content }</textarea>
					</c:if>
					<c:if test = "${id ne revBoard.writer && id ne 'admin' }">
						<textarea name = "content" rows = "6" cols = "90" readonly>${revBoard.content }</textarea>
					</c:if>
				</td>
			</tr>
		</table>
		<div>
			<button type = "button" onclick = "location.href = 'revBoardList.do'">목록 보기</button>
			<c:if test = "${id eq revBoard.writer || id eq 'admin' }">
				<button type = "submit">수정</button>
				<button type = "button" onclick = "revDelete()">삭제</button>
			</c:if>
		</div>
	</form>
</div>
