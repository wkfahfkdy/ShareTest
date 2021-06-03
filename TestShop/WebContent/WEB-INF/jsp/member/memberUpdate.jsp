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
	
	.asdf {
		width: 720px;
		text-align: left;
	}
	
</style>
<script>
	function numberLength(e) {
		if(e.value.length > e.maxLength){
			e.value = e.value.slice(0, e.maxLength);
		}
	}
	
	/* function selectEmail(){
		
		var target = document.getElementById("email");
		
		console.log(target);
		
		if(target.options[target.selectedIndex].text == "직접입력") {
			document.update.email.disabled = false;
			document.update.email.value = "";
			document.update.email.focus();
		} else if(target.options[target.selectedIndex].text == "선택") {
			document.update.email.readonly = true;
			document.update.email.value = "";
		} else {
			document.update.email.disabled = false;
			document.update.email.value = target.options[target.selectedIndex].value;
			alert('선택된 옵션 value 값 = ' + document.update.email.value); 
		}
	} */
	
	/* $(function(){
		$('#pwdCheck').click(function(){
			if($('#mPwd').val() != $('#iPwd').val()){
				alert('비밀번호가 같지 않다.');
				$('#iPwd').focus();
			} else {
				alert('같다');
			}
			
			return;
		});
	}); */
	
	function checkThePwd(){
		
		let modiPwd = document.getElementsByName('mPwd')[0].value;	// 수정 비번
		let idenPwd = document.getElementsByName('iPwd')[0].value;	// 확인 비번
		
		if(modiPwd != idenPwd){
			
			alert('XXXXXXXXXXXXXXX');
			frm.iPwd.focus();
			
		} else {
			
			alert('O');
			frm.pwdCheck.value = "checked";
		}
		
	}
	
	function submitBtn(){
		
		let modiPwd = document.getElementsByName('mPwd')[0].value;	// 수정 비번
		let checkPwd = document.getElementsByName('pwdCheck')[0].value;	// 비번 확인 버튼
		let emailWrite = document.getElementsByName('mail')[0].value;	// 입력 이메일
		let emailSelect = document.getElementsByName('localEmail')[0].value;	// 선택 이메일
		let frontNumber = document.getElementsByName('phoneNumber1')[0].value;	// 전번 앞번호
		let backNumber = document.getElementsByName('phoneNumber2')[0].value;	// 전번 뒷번호
		
		if(modiPwd != "" && checkPwd == "unChecked") {
			
			alert('비밀번호 확인 버튼 체크해라')
			frm.iPwd.focus();
			return;
			
		} else if(emailWrite != "" && emailSelect == '선택'){
			
			alert('이메일 주소 선택해라')
			frm.mail.focus();
			return;
				
		} else if((frontNumber != "" || backNumber != "") && (frontNumber.length < 4 || backNumber.length < 4)){
		
			alert('수정할 전화번호를 8자리 모두 입력해라.')
			frm.phoneNumber1.focus();
			return;
		
		} else {
			
			alert('수정됐다');
			frm.submit();
			
		}
	}
	
	
	/* 
	최종 킄릭 시 필요한 요소
		완 1. 전화 번호 수정했을 경우, phoneNumber1, 2 각각 네 자리를 충족했는가.
		완 2. 이메일 수정할 때 <선택사항>을 적용시켰는가.
		완 3. 비밀번호 수정 <확인> 버튼을 눌렀는가. ~> unChecked 이용하면 됨 (memberJoinForm.jsp)
		미완 + 아이디 비밀번호 한글 입력 불가능으로!
			+ 이 창으로 오기 전에 회원 정보 입력 창으로 이동시켜 본인 인증 받게. (memberInfoCheck.java)
	*/
	
</script>
<body>

	<h2>내 정보 수정</h2>

	<div align = "center">
	
		<div class="asdf">
			<Strong>${id }</Strong> 님의 연락처 정보입니다.<br>
			회원정보는 개인정보처리방침에 따라 안전하게 보호되며, 회원님의 명백한 동의 없이 공개 또는<br>제 3자에게 제공되지 않습니다.<br>
			<a href = "#" target = "_blank">개인정보처리방침</a>
		</div>
		<br>
		<form name = "frm" action = "memberUpdateForm.do" method = "post">
		
			<input type = "hidden" name = "hiddenPhone" value = ${vo.phone }>
			<input type = "hidden" name = "hiddenName" value = ${vo.name }>
			<input type = "hidden" name = "hiddenMail" value = ${vo.mail }>
			<input type = "hidden" name = "hiddenAddr" value = ${vo.address }>
			<input type = "hidden" name = "hiddenPwd" value = ${vo.passwd }>
			
			<table frame = void>
				<tr>
					<th>이름</th>
					<td>
						${vo.name }
						<p><br><input type = "text" name = "mName" placeholder = "바꿀 이름 입력." maxlength = "30"></p>
					</td>
				</tr>
				
				<tr>
					<th>비번 수정</th>
					<td>
						<input type = "password" name = "mPwd" placeholder = "수정할 비밀번호 입력" maxlength = "20">
						<p><br>
							<input type = "password" name = "iPwd" placeholder = "비밀번호 재입력"  maxlength = "20">
							<button type = "button" name = "pwdCheck" onclick = "checkThePwd()" value = "unChecked">확인</button>
						</p>
					</td>
				</tr>
				
				<tr>
				<th>전번</th>
					<td>
						${vo.phone }<br><br>
						<select name = "localPhoneNumber" style = "width : 150px;">
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
					<th>이멜</th>
					<td>
						${vo.mail }<br><br>
						<input type = "text" name = "mail" maxlength="30"> @ 
						<!-- <input type = "text" name = "email" id = "email" value ="" readonly> -->
						<select name = "localEmail" style = "width : 150px;">
						 <!-- onchange = "selectEmail()" -->
							<option>선택</option>
							<!-- <option>직접입력</option> -->
							<option value = "@naver.com">naver.com</option>
							<option value = "@google.com">google.com</option>
							<option value = "@daum.net">daum.net</option>
							<option value = "@nate.net">nate.net</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<th>주소</th>
					<td>
						${vo.address}
						<p><br><input type = "text" name = "addr" maxlength = "30"></p>
					</td>
				</tr>
			</table>
			<div class = "btn_group">
				<input type = "button" value = "수정" onclick = "submitBtn()">
			</div>
		</form>
	</div>
</body>
</html>