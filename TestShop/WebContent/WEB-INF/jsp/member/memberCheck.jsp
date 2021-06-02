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

		let userID = ${id};
		let userPwd = ${userInfo.passwd};
		
		console.log(userID);
		console.log(userPwd);
		
		if(frm.memberId.value == ""){
			alert("아이디 입력");
			frm.memberId.focus();
			return false;
		}
		if(frm.memberPwd.value == "") {
			alert("비번 입력");
			frm.memberPwd.focus();
			return false;
		}
		
		if(frm.memberId.value != ${id} || frm.memberPwd.value != ${userInfo.passwd}){
			alert("정보가 바르지 않다.");
			frm.memberId.focus();
			return false;
		}
		
		frm.submit();
		
	}
	
</script>

<body>
	<div class = "memberCheckWindow">
		<div align = "center">
			
			<h2><Strong>본인 확인을 위해 정보 재입력</Strong></h2>
		
			<form id = "frm" action = "MemberInfoCheck.do" method = "post">
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
