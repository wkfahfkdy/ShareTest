<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>	
			<th></th><th>상품명</th><th>개수</th><th>가격</th><th>할인가</th><th>계</th>
		</tr>
	<c:forEach items="${list }" var="list">
		<td><img src = "upload/${list.itemImage }" alt = "..." width = "50px" height = "50px" /></td>
		<td>${list.itemName }</td>
		<td>${list.qtySum }</td>
		<td>${list.price }</td>
		<td>${list.salePrice }</td>
		<td>${list.priceSum }</td>
	</c:forEach>
	</table>
</body>
</html>