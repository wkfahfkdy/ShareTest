<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 확인</title>
</head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	
	function formCheck(){

		let userID = document.getElementsByName('id')[0].value;
		let userPwd = document.getElementsByName('passwd')[0].value;
		
		if(memberId.value == ""){
			
			alert("아이디 입력");
			memberId.focus();
			return false;
			
		} else if(memberPwd.value == "") {
			
			alert("비번 입력");
			memberPwd.focus();
			return false;
			
		} else if(memberId.value != userID || memberPwd.value != userPwd){
			
			alert("정보가 바르지 않다.");
			memberId.focus();
			return false;
			
		} else {
			
			frm.submit();
		}
	}
	
</script>
<!-- 
사용자가 이 페이지를 통과한 뒤로 웹페이지 열한 시 방향 '이전 페이지' 버튼을 누를 경우 문제 발생.
: '이전 페이지'로 해당 화면으로 돌아온 뒤 '앞으로 가기'를 누르면 정보 입력 없이 다음 페이지로 넘어가짐.
-->
<body>
	<div class = "memberCheckWindow">
		<div align = "center">
			
			<h2><Strong>본인 확인을 위해 정보 재입력</Strong></h2>
		
			<form id = "frm" action = "memberInfoCheck.do" method = "post">
			
				<div class = showWindow">
				
				<input type = "hidden" name = "id" value = "${id }">
				<input type = "hidden" name = "passwd" value = "${userInfo.passwd }">
				
					<table>
						<tr>
							<th>ID</th>
							<td><input type = "text" id = "memberId" name = "memberId"></td>
						</tr>
						<tr>
							<th>PW</th>
							<td><input type = "password" id = "memberPwd" name = "memberPwd"></td>
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
