<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberLoginForm.jsp</title>
	<!-- 
		로그인창. 홈페이지 접속시 가장 첫 화면 중앙에 보일 것
		게스트가 특정 행동 시 첫 페이지로 돌아가게해서 로그인하도록
		ID 체크 - PWD 체크 이후 전송	
	-->
<script>
	function formcheck() {
		if(frm.memberId.value == "") {
			alert("아이디를 입력하시오");
			frm.memberId.focus;
			return false;
		}
		if(frm.memberPwd.value == "") {
			alert("비밀번호를 입려하시오");
			frm.memberPwd.focus;
			retrun false;
		}
		
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<form id = "frm" action="memberLogin.do" method="post">
			<div>
				<table>
					<tr>
						<th>ID</th>
						<td><input type="text" id="memberId" name="memberId"></td>
					</tr>
					<tr>
						<th>PW</th>
						<td><input type="password" id="memberPwd" name="memberPwd"></td>
					</tr>
				</table>
			</div>
			<div>
				<button type="button" onclick="formcheck()">로그인</button>
			</div>
		</form>
		<form id = "frm2" action="memberJoinForm.do" method="post">
			<div>
				<button type="button">회원 가입</button>
			</div>
		</form>
	</div>
</body>
</html>