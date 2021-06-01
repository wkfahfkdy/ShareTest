<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>

<style>
	input::-webkit-outer-spin-button,
	input::-webkit-inner-spin-button {
		-webkit-appearance: none;
	}
	
	th {
		background-color: #FDF5E6;
		width: 150px;
		height: 150px;
		text-align : center;
	}
	
	th, td {
		border : 1px solid #FFE4B5;
		padding : 20px;
	}
	
	strong {
		color : #DCAD67;
	}
	
</style>
<script>
	function numberLength(e) {
		if(e.value.length > e.maxLength){
			e.value = e.value.slice(0, e.maxLength);
		}
	}
</script>
<body>

	<h2>내 정보 수정</h2>

	<div align = "center" width = "60%">
	
		<span>
			<Strong><b>${id }</b></Strong> 님의 연락처 정보입니다.
			회원정보는 개인정보처리방침에 따라 안전하게 보호되며, 회원님의 명백한 동의 없이 공개 또는 제 3자에게 제공되지 않습니다.
			<a href = "#" target = "_blank">개인정보처리방침</a>
		</span>
	
		<form method = "post">
			<table frame = void>
				<tr>
					<th>이름</th>
					<td><input type = "text" name = "mName" placeholder = "${vo.name}"></td>
				</tr>
				
				<tr>
					<th>현재 비번</th>
					<td><input type = "password" name = "nPwd"></td>
				</tr>
				
				<tr>
					<th>수정 비번</th>
					<td><input type = "password" name = "mPwd"></td>
				</tr>
				
				<tr>
					<th>비번 확인</th>
					<td><input type = "password" name = "iPwd"></td>
				</tr>
				
				<tr>
				<th>전번</th>
					<td>
						<select class = "localPhoneNumber" style = "width : 150px;">
							<option value = "010">010</option>
							<option value = "053">053</option>
						</select> -
						<span>
							<input class = "form-number-control" type = "number" name = "phoneNumber1" maxlength = "4" placeholder= "숫자 4자리" oninput = "numberLength(this);">
						</span> -
						<span>
							<input class = "form-number-control" type = "number" name = "phoneNumber2" maxlength = "4" placeholder = "숫자 4자리" oninput = "numberLength(this);">
						</span>
					</td>
				</tr>
				
				<tr>
					<th>메일</th>
					<td>
						<input type = "text" name = "mail"> @
						<select class = "localEmail" style = "width : 150px;">
							<option value = "naver">naver</option>
							<option value = "google">google</option>
							<option value = "daum">daum</option>
							<option value = "nate">nate</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<th>주소</th>
					<td><input type = "text" name = "addr"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>