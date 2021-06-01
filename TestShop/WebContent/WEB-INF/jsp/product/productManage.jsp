<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>상품 입력</h3><br>
		<form id = "frm" action="fileUpload.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>Item_Code  </td><td><input type="text" name="itemCode"></td>
				</tr>
				<tr>
					<td>Item_Name  </td><td><input type="text" name="itemName"></td>
				</tr>
				<tr>
					<td>Item_Image  </td><td><input type="file" name="itemImage"></td>
				</tr>
				<tr>
					<td>Price  </td><td><input type="number" name="price"></td>
				</tr>
				<tr>
					<td>Item_Desc  </td><td><input type="text" name="itemDesc"></td>
				</tr>
				<tr>
					<td>Sale  </td><td><input type="radio" name="sale" value="Y"> Y <input type="radio" name="sale" value="N"> N  </td>
					<!-- Y/N 선택지 -->
				</tr>
				<tr>
					<td>Sale_Price  </td><td><input type="number" name="salePrice"> Y : 100% / N : 80% 가격 입력</td> 
					 <!-- Y 할거라면 80% 가격 N면 100% 가격 입력 -->
				</tr>
				<tr>
					<td>Division  </td><td><input type="radio" name="division" value="쿠키"> 쿠키 <input type="radio" name="division" value="빵"> 빵 <input type="radio" name="division" value="간편식"> 간편식 <input type="radio" name="division" value="음료"> 음료</td>
				</tr>
			</table><br>
			<input type="submit" value="upload">
		</form>
	</div>
</body><br>
</html>