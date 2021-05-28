<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberJoinForm.jsp</title>
	<!-- 
		회원가입창. 
		필요 사항 : ID, NAME, PASSWD, PHONE, MAIL, ADDRESS
	 -->
	 
<script>
	$(function () {
		// ID 빈칸 확인
		$('#idCheck').click(function() {
			if($('#memberId').val() == "") {
				alert('아이디를 입력하시오');
				$('#memberId').focus;
			} return;
		});
		
		// 비밀번호 재확인 체크
		$('#pwdCheck').click(function () {
			if($('#memberPwd').val() != $('#memberPwd2').val()) {
				alert('비밀번호가 같지 않습니다');
				$('#memberPwd')/focus;
			}; return;
		});
		
		// ID 중복 체크
		$.ajax({
			url: 'memberIdCheck',
			data: {id: $('#memberId').val()},
			type: 'post',
			success: function(data){
				if(data > 0) {
					alert('아이디가 존재합니다. 다른 아이디를 입력하시오');
					$('memberId').val("");
					$('memberId').focus();
				} else {
					alert('사용 가능한 아이디입니다');
					$('#idCheck').val('checked')
					$('#memberPwd').focus();
				}
			},
			error: function(err) {
				console.log(err);
			}
		});
	});
	
	$(function() {
		
		$('#pwdCheck').click(function (){
			if($('memberPwd').val() != $('memberPwd2').val() ){
				alert('비밀번호가 일치하지않습니다');
				$('memberPwd').focus();
				return;
			}
		}
	});
	
	function formCheck() {
		
		if(frm.memberId.value == "") {
			alert("아이디를 입력하시오");
			frm.memberId.focuse();
			return false;
		}
		if(frm.idCheck.value == "unChecked"){
			alert("아이디 중복 체크를 하시오");
			return false;
		}
		if(frm.memberPwd.value == "") {
			alert("비밀번호를 입력하시오");
			frm.memberPwd.focuse();
			return false;
		}
		
		frm.submit();
	}
</script>
</head>
<body>
	<div>
		<h2> 회원 가입 </h2>
	</div>
	<div align="center">
		<form id="frm" action="memberJoin.do" method="post">
			<div>
				<table>
					<tr>
						<th width="150">아이디 : </th>
						<td width="330"><input type="text" id="memberId" name="memberId">
						<button type="button" id="idCheck" value="unChecked">중복 체크</button>
					</tr>
					<tr>
						<th width="150">이름 : </th>
						<td width="330"><input type="text" id="memberName" name="memberName">
					</tr>
					<tr>
						<th width="150">비밀번호 : </th>
						<td width="330"><input type="password" id="memberPwd" name="memberPwd"><br>
						<th width="150">비밀번호 재확인 : </th>
						<td width="330"><input type="password" id="memberPwd2" name="memberPwd2">
						<button type="button" id="pwdCheck" value="nonChecked">확인</button>
					</tr>
					<tr>
						<th width="150">연락처 : </th>
						<td width="330"><input type="text" id="memberPhone" name="memberPhone">
					</tr>
					<tr>
						<th width="150">이메일 : </th>
						<td width="330"><input type="text" id="memberMail" name="memberMail">
					</tr>
					<tr>
						<th width="150">주소 : </th>
						<td width="330"><input type="text" id="memberAddr" name="memberAddr">
					</tr>
				</table>
			</div>
			<div>
				<button type="button" onclick="formCheck()">회원가입</button>
				<button type="button" onclick="location.href='main.do'">메인화면</button>
			</div>
		</form>
	</div>
</body>
</html>