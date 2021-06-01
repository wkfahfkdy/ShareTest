<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<td width="100px">${list.price }</td>
					<td width="100px">${list.salePrice }</td>
					<td width="100px">${list.priceSum }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
</body>
</html>