<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					<img class="card-img-top mb-5 mb-md-0" src="upload/${vo.itemImage }">
				</div>
				<div class="col-md-6">
					<div class="small mb-1">${vo.itemCode }</div>
					<h1 class="display-5 fw-bolder">${vo.itemName }</h1>
					<div class="fs-5 ms-5">
						<c:if test="${vo.sale eq 'Y' }">
							<span class="text-decoration-line-through"><fmt:formatNumber type="currency" value="${vo.price }"></fmt:formatNumber></span>
						</c:if>
						<span><fmt:formatNumber type="currency" value="${vo.salePrice }"></fmt:formatNumber></span>
					</div>
					<p class="lead">
						${vo.itemDesc } <br>
						<!-- 설명 늘릴려고 적은것. 나중에 지우기 -->
						safsdafdfsafsa <br>
						sdafsfsf <br>
						sdaf <br>
						sdaf <br>
						safsdafsdafsdaf <br>
						sdafsdafsafsfsdafsdaf <br>
						sdfsafafdf <br>
						sdafsdafasdfsdafsdafsafsdafsdafsdafsdafsdafsfsfsdafsdfsdafsafd <br>
						safsdafsdfsdafsdafsdafsafaadsf <br>
					</p>
				</div>
			</div>
			<br><br><br>
			<div align="center"> 
				<form id = "frm" action="fileUploadUpdate.do" method="post" enctype="multipart/form-data">
					<table>
						<tr>
							<td>Item_Code  </td><td><input type="text" name="itemCode" value="${vo.itemCode }"></td>
						</tr>
						<tr>
							<td>Item_Name  </td><td><input type="text" name="itemName" value="${vo.itemName }"></td>
						</tr>
						<tr>
							<td>Item_Image  </td><td><input type="file" name="itemImage"></td>
						</tr>
						<tr>
							<td></td><td>기존 파일 경로2 : upload/${vo.itemImage }</td>
						</tr>
						<tr>
							<td>Price  </td><td><input type="number" name="price" value="${vo.price }"></td>
						</tr>
						<tr>
							<td>Item_Desc  </td><td><input type="text" name="itemDesc" value="${vo.itemDesc }"></td>
						</tr>
						<tr>
							<td>Like_It  </td><td>${vo.likeIt }<input type="hidden" name="likeIt" value="${vo.likeIt }"></td>
						</tr>
						<tr>
							<td>Sale  </td><td><input type="radio" name="sale" value="Y"> Y <input type="radio" name="sale" value="N"> N  </td>
							<!-- Y/N 선택지 -->
						</tr>
						<tr>
							<td>Sale_Price  </td><td><input type="number" name="salePrice"  value="${vo.salePrice }"> Y : 100% / N : 80% 가격 입력</td> 
							 <!-- Y 할거라면 80% 가격 N면 100% 가격 입력 -->
						</tr>
						<tr>
							<td>Division  </td><td><input type="radio" name="division" value="쿠키"> 쿠키 <input type="radio" name="division" value="빵"> 빵 <input type="radio" name="division" value="간편식"> 간편식 <input type="radio" name="division" value="음료"> 음료</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><input type="submit" value="Update"></td><td></td>
						</tr>
					</table><br>
				</form>
			</div>
		</div>
	</section>
</body>
</html>