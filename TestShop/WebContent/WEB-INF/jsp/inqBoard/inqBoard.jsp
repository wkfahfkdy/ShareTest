<%@page import="com.shop.comment.vo.CommentVO"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.comment.serviceImpl.CommentServiceImpl"%>
<%@page import="com.shop.comment.service.CommentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>

<script>
	$(function () {
		CKEDITOR.replace('content', {
			filebrowserUploadUrl: '${pageContext.request.contextPath}/fileUpload',
			height: '600px',
			width: '800px'
		});
	});

	function inqDelete() {

		let id = document.getElementsByName("id")[1].value;

		$.ajax({
			url: 'inqDeleteServlet',
			type: 'post',
			data: {
				id
			},
			success: function () {
				location.href = "inqBoardList.do";
			},
			error: function (err) {
				console.log(err);
			}
		});
	}

	function btnReply() {
		var replytext = $("#replytext").val();
		var bno = $("#bid").val(); // 게시물 번호
		console.log(bno);

		$.ajax({
			url: "icomInsert.do",
			data: {
				replytext: replytext,
				bno: bno
			},
			success: function () {
				alert("댓글 등록ㅇ");
				//listReply();

				location.reload();
			},
			error: function (err) {
				console.log(err);
			}
		});
	};

	/* function listReply() {
		var bno=$("#bid").val();
		
		$.ajax({
			url: "icomList.do",
			data: {
				bno: bno
			},
			success: function(result) {
				$("#listReply").html(result);
				location.reload;
			},
			error: function(err){
				console.log(err);
			}
		});
	} */

	function btnNest(e) {
		var replytext = $("#nesttext").val();
		var bno = $("#bid").val(); // 게시물 번호
		var depth = $(".depth").val();
		var rno = $(".rno").val();
		
		//console.log(rno + "," + depth + "," + bno + "," + replytext);
		//console.log(e);
		
		$.ajax({
			url: "nestInsert.do",
			data: {
				replytext: replytext,
				bno: bno,
				depth: depth,
				rno: rno
			},
			success: function () {
				alert("댓글 등록ㅇ");
				//listReply();

				location.reload();

			},
			error: function (err) {
				console.log(err);
			}
		}); 
	}

	function nestedForm(e, value) {
		$('.checkTr').each(function () {
			//console.log(e);
			//console.log(e.target);
			if(e.target.nodeName == 'TEXTAREA' || e.target.nodeName == "BUTTON" ){
				return;				
			} else {
				$(this).find('textarea').remove();
				$(this).find('button').remove();
			}
		})
		
		if(e.target.nodeName == 'TEXTAREA' || e.target.nodeName == "BUTTON" ){
			return;
		} else {
			$(e.target).append(
				'<textarea rows="1" cols="50" class="tq" id="nesttext" placeholder="댓글 작성란"></textarea><button class="btn btn-outline-dark mt-auto" type="button" onclick="btnNest(event)">댓글 작성</button>'
			);
		}
		
		/* console.log($(e.target).find('textarea').length);
		if ($(e.target).find('textarea').length != 0) {
			return;
		} */
	}
</script>

<style>
	.tq {
		position : relative; 
		top: 9px;
	}
</style>

<div align="center">

	<h3>문의 내용</h3>

	<form action="inqBoardUpdate.do" id="frm" method="post">
		<table border="1">
			<tr>
				<th>순번</th>
				<td><input type="hidden" id="bid" name="id" value="${inqBoard.id }">${inqBoard.id }</td>
				<th>작성일</th>
				<td>${inqBoard.regDate }</td>
				<th>작성자</th>
				<td>${inqBoard.writer }</td>
				<th>조회수</th>
				<td>${inqBoard.hit + 1 }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="7">
					<c:if test="${id eq inqBoard.writer || id eq 'admin' }">
						<input name="title" type="text" value="${inqBoard.title }">
					</c:if>
					<c:if test="${id ne inqBoard.writer && id ne 'admin' }">
						${inqBoard.title }
					</c:if>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="7">
					<c:if test="${id eq inqBoard.writer || id eq 'admin' }">
						<textarea name="content" rows="6" cols="90">${inqBoard.content }</textarea>
					</c:if>
					<c:if test="${id ne inqBoard.writer && id ne 'admin' }">
						<textarea name="content" rows="6" cols="90" readonly>${inqBoard.content }</textarea>
					</c:if>
				</td>
			</tr>
		</table>
		<br>
		<div>
			<h4>댓글</h4>
		</div>
		<!-- 댓글 입력할 곳 만들어야함 -->
		<div style="width:900px; text-align:center;">
			<c:if test="${id != null }">
				<table align="center">
					<tr>
						<td><textarea rows="2" cols="106" id="replytext" placeholder="댓글 작성란"></textarea></td>
						<td><button class="btn btn-outline-dark mt-auto" type="button" onclick="btnReply()">댓글 작성</button></td>
					</tr>
				</table>
			</c:if>
		</div>
		<div id="listReply">
			<table border="1">
				<c:forEach items="${list }" var="list">
					<tr class="checkTr">
						<td width="100px">${list.writer }</td>
						<td width="650px" class="Nest" onclick="nestedForm(event, '${list.content }')">
							${list.content }<input type="hidden" class="depth" value="${list.depth }"><input type="hidden" class="rno" value="${list.rno }">
						</td>
						<td width="100px">${list.regdate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<br>
		<div>
			<button class="btn btn-outline-dark mt-auto" type="button" onclick="location.href = 'inqBoardList.do'">돌아가기</button>
			<c:if test="${id eq inqBoard.writer || id eq 'admin' }">
				<button class="btn btn-outline-dark mt-auto" type="submit">수정</button>
				<button class="btn btn-outline-dark mt-auto" type="button" onclick="inqDelete()">삭제</button>
			</c:if>
		</div>

	</form>
</div>