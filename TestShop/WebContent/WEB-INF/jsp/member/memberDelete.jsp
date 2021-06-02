<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>

<!-- 
1. 우선 회원 본인 확인을 위해 아이디와 비밀번호 입력받기.
2. 입력받으면 그제야 탈퇴 창으로 이동.
3. 탈퇴 문구 입력시킨 뒤 값이 동일하면 탈퇴 처리, 같지 않으면 false.
3-1. 탈퇴 처리 완료 시 index.do로 이동. 
-->

<body>
	<div class = "escapeCheckWindow">
		<div align = "center">
			
			<h3><Strong>본인 확인을 위해 정보 재입력</Strong></h3>
		
			<form id = "frm" action = "#" method = "post">
				<div class = showWindow">
					<table>
						<tr>
							<th>ID</th>
							<td><input type = "text" id = "memberId" name = "memberId"></td>
						</tr>
						<tr>
							<th>PW</th>
							<td><input type = "text" id = "memberPwd" name = "memberPwd"></td>
						</tr>
					</table>
				</div>
				<div class = "buttonCollect">
					<button type = "button" onclick = "formCheck()">확인</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
