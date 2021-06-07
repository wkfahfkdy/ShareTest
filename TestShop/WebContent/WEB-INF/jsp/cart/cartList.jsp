<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	th,td {
		text-align: center;
	}
</style>
<script>
	// 게시글 ID로 조회
	function formSubmit(itemCode){
		
		$.ajax({
			url: 'goDesc.do',
			data: {itemCode: itemCode},
			success: function(result){
				location.href="productListDesc.do"
			},
			error: function(err){
				console.log(err);
			}
		});
	}
	
	function cartDelete(itemCode, id) {

		$.ajax({
			url: 'cartDelete.do',
			data: {itemCode: itemCode, id: id},
			success: function(result){
				alert('물품 삭제')
				location.reload();
			},
			error: function(err){
				console.log(err);
			}
		});
	}
	
	function cartDelete(qtySum, itemCode, id) {

		$.ajax({
			url: 'cartUpdate.do',
			data: {qtySum: qtySum, itemCode: itemCode, id: id},
			success: function(result){
				alert('수량 수정')
				location.reload();
			},
			error: function(err){
				console.log(err);
			}
		});
	}
</script>
</head>
<body>
	<div align="center">
		<form id="frm" action="goDesc.do" method="POST">
			<table>
				<tr>	
					<th></th><th>상품명</th><th>개수</th><th>가격</th><th>구매가</th><th>계</th>
				</tr>
				<c:forEach items="${list }" var="list">
					<tr>
						<td width="100px"><img src = "upload/${list.itemImage }" alt = "..." width = "50px" height = "50px" /></td>
						<td width="100px" onclick="formSubmit('${list.itemCode}')">${list.itemName }</td>
						<td width="100px"><input type="number" value="${list.qtySum }" style="width:30px;"></td>
						<td width="100px"><fmt:formatNumber value="${list.price }" type="currency"></fmt:formatNumber></td>
						<td width="100px"><fmt:formatNumber value="${list.salePrice }" type="currency"></fmt:formatNumber></td>
						<td width="100px"><fmt:formatNumber value="${list.priceSum }" type="currency"></fmt:formatNumber></td>
						<td><button class="btn btn-outline-dark mt-auto" type="button" onclick="cartUpdate('${list.itemCode}', '${list.qtySum}', '${id }')">수정</button></td>
						<td><button class="btn btn-outline-dark mt-auto" type="button" onclick="cartDelete('${list.itemCode}', '${id }')">삭제</button></td>
					</tr>
				</c:forEach>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4"></td>
					<td colspan="2">
						<h5>
							총합계 : <fmt:formatNumber value="${fsum }" type="currency"></fmt:formatNumber>
						</h5>
					</td>
				</tr>
			</table><br>
		</form>
	</div>
	<br>
</body>
</html>