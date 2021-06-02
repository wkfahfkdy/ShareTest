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
		
		/*
		우측 상단에서 로그인 버튼 눌러서 이동한 index.do 경로라면 정상 작동.
		그 외에는 '실제 패스'가 받아지지 않음.
			ex) 실행하고 첫 화면,
				로그아웃한 뒤,
				로그아웃한 뒤 곧장 우측 상단 로그인 버튼 누를 경우. (후기따위의 다른 경로를 거처서 이동해야 재작동.) 
		*/
		
		let realPass = document.getElementsByName('hiddenPwd')[0].value;
		let pass = document.getElementById('memberPwd').value;
		
		console.log('실제 패스 : ' + realPass);
		console.log('입력 패스 : ' + pass);
		// 여기까지 새로 추가된 것들.
		
		if(frm.memberId.value == "") {
			alert("아이디를 입력하시오");
			frm.memberId.focus();
			return false;
		}
		if(frm.memberPwd.value == "") {
			alert("비밀번호를 입력하시오");
			frm.memberPwd.focus();
			return false;
		}
		
		$.ajax({
			url : 'memberIdCheck',
			data: {id :	$('#memberId').val()},
			type : 'post',
			success : function(){
				
				/* function 매개 변수 지우고 if(resp > 0)를 if(pass == realPass)로 변경 */
				
				if(pass == realPass) {
					frm.submit();
				} else {
					alert('정보가 바르지 않다.');
					return false;
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
			<input type = "hidden" name = "hiddenPwd" value = "${vo.passwd }"> <!-- 집에서 추가 -->
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