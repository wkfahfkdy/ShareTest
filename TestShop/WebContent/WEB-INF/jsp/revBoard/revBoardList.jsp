<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기</title>
<script>
	// 게시글 ID로 조회
	function formSubmit(revBoardID){
		
		frm.id.value = revBoardID;
		frm.submit();
	}
	
	function goPage(page){
		location.href = "revBoardList.do?page=" + page;
	}
</script>
<style>
.pagination {
	display : inline-block;
}

.pagination a {
	color : black;
	float : left;
	padding : 8px 16px;
	text-decoration : none;
}
</style>
</head>
<body>
	<h3>후기</h3>
	<form id="frm" action="revBoardSelect.do" method="POST">
		<input type="hidden" id="id" name="id">
	</form>
	<div align="center">
		<div style="width: 80%">
			<table class="table" border="1">
				<tr>
					<th width="100">순번</th>
					<th width="200">제목</th>
					<th width="150">작성자</th>
					<th width="150">작성일자</th>
					<th width="100">조회수</th>
				</tr>
				<c:forEach items="${revBoardList }" var="vo">
					<tr>
						<td>${vo.id }</td>
						<td onclick="formSubmit(${vo.id})">${vo.title }</td>
						<td>${vo.writer }</td>
						<td>${vo.regDate }</td>
						<td>${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<!-- <button type="button" onclick="location.href = 'index.do'">홈</button> -->
				<c:if test="${!empty id }">
					<button type="button" onclick="location.href = 'revBoardForm.do'">등록</button>
				</c:if>
			</div>
			<jsp:include page = "../common/paging.jsp" flush = "true">
				<jsp:param value="${paging.firstPageNo }" name="firstPageNo"/>
				<jsp:param value="${paging.prevPageNo }" name="prevPageNo"/>
				<jsp:param value="${paging.startPageNo }" name="startPageNo"/>
				<jsp:param value="${paging.pageNo }" name="pageNo"/>
				<jsp:param value="${paging.endPageNo }" name="endPageNo"/>
				<jsp:param value="${paging.nextPageNo }" name="nextPageNo"/>
				<jsp:param value="${paging.finalPageNo }" name="finalPageNo"/>
			</jsp:include>
		</div>
	</div>
</body>
</html>