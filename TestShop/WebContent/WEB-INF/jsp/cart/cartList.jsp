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
</head>
<body>
	<div align="center">
		<table>
			<tr>	
				<th></th><th>상품명</th><th>개수</th><th>가격</th><th>구매가</th><th>계</th>
			</tr>
			<c:forEach items="${list }" var="list">
				<tr>
					<td width="100px"><img src = "upload/${list.itemImage }" alt = "..." width = "50px" height = "50px" /></td>
					<td width="100px">${list.itemName }</td>
					<td width="100px">${list.qtySum }</td>
					<td width="100px"><fmt:formatNumber value="${list.price }" type="currency"></fmt:formatNumber></td>
					<td width="100px"><fmt:formatNumber value="${list.salePrice }" type="currency"></fmt:formatNumber></td>
					<td width="100px"><fmt:formatNumber value="${list.priceSum }" type="currency"></fmt:formatNumber></td>
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
		
	</div>
	<br>
</body>
</html>