<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.16.1/full/ckeditor.js"></script>

<script>
	$(function(){
		CKEDITOR.replace('content',{
			filebrowserUploadUrl : '${pageContext.request.contextPath}/fileUpload',
			height : '600px',
			width : '800px'
		});
	});
	
	function inqDelete(){
		
		let id = document.getElementsByName("id")[1].value;
		
		$.ajax({
			url : 'inqDeleteServlet',
			type : 'post',
			data : {id},
			success : function(){
				location.href = "inqBoardList.do";
			},
			error : function(err){
				console.log(err);
			}
		});
	}
</script>

<div align = "center">

	<h3>문의 내용</h3>
	
	<form action="inqBoardUpdate.do" id = "frm" method = "post">
		<table border = "1">
			<tr>
				<th>순번</th>
				<td><input type = "hidden" name = "id" value = "${inqBoard.id }">${inqBoard.id }</td>
				<th>작성일</th>
				<td>${inqBoard.regDate }</td>
				<th>작성자</th>
				<td>${inqBoard.writer }</td>
				<th>조회수</th>
				<td>${inqBoard.hit + 1 }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan = "7">
					<c:if test = "${id eq inqBoard.writer || id eq 'admin' }">
						<input name = "title" type = "text" value = "${inqBoard.title }">
					</c:if>
					<c:if test = "${id ne inqBoard.writer && id ne 'admin' }">
						${inqBoard.title }
					</c:if>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan = "7">
					<c:if test = "${id eq inqBoard.writer || id eq 'admin' }">
						<textarea name = "content" rows = "6" cols = "90">${inqBoard.content }</textarea>
					</c:if>
					<c:if test = "${id ne inqBoard.writer && id ne 'admin' }">
						<textarea name = "content" rows = "6" cols = "90" readonly>${inqBoard.content }</textarea>
					</c:if>
				</td>
			</tr>
		</table>
		<div>
			<button type = "button" onclick = "location.href = 'inqBoardList.do'">돌아가기</button>
			<c:if test = "${id eq inqBoard.writer || id eq 'admin' }">
				<button type = "submit">수정</button>
				<button type = "button" onclick = "inqDelete()">삭제</button>
			</c:if>
		</div>
	</form>
</div>