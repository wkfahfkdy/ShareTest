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
		
		if(memberId.value == "") {
			alert("아이디를 입력하시오");
			memberId.focus();
			return false;
		}
		if(memberPwd.value == "") {
			alert("비밀번호를 입력하시오");
			memberPwd.focus();
			return false;
		}
		
		$.ajax({
			url: 'memberIdCheck',
			data : {
				id : memberId.value,
				pwd : memberPwd.value
			},
			type: 'post',
			success: function(resp){
				
				if(resp == "null"){
					
					alert('틀렸다');
					memberPwd.value = null;
					memberId.focus();
					
				} else { 
					
					frm.submit();
				}
			},
			error : function(err){
				console.log(err);
			}
		});
	}
</script>
</head>
<body>
	<div class="py-5">
		<div align="center">
			<form id="frm" action="memberLogin.do" method="post">
				<div>
					<table>
						<tr>
							<th>ID </th>
							<td><input type="text" id="memberId" name="memberId"></td>
						</tr>
						<tr>
							<th>PW </th>
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
					<button type="submit">회원 가입</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>