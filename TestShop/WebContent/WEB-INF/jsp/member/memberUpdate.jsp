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
		
		if($('#mPwd').val() != $('#iPwd').val()){
			
			alert('XXXXXXXXXXXXXXX');
			$('#iPwd').focus();
		} else {
			alert('O');
		}
		
	}
	
	/* 
	기능 안 함.
	최종 킄릭 시 필요한 요소
		1. 전화 번호 수정했을 경우, phoneNumber1, 2 각각 네 자리를 충족했는가.
		2. 이메일 수정할 때 <선택사항>을 적용시켰는가.
		3. 비밀번호 수정 <확인> 버튼을 눌렀는가. ~> unChecked 이용하면 됨 (memberJoinForm.jsp)
		+ 아이디 비밀번호 한글 입력 불가능으로!
		
	$('#submitBtn').click(function(){
		
		alert('수정됨');
		location.href = "index.do";
	}); */
	
</script>
<body>

	<h2>내 정보 수정</h2>

	<div align = "center">
	
		<span>
			<Strong><b>${id }</b></Strong> 님의 연락처 정보입니다.
			<p>회원정보는 개인정보처리방침에 따라 안전하게 보호되며, 회원님의 명백한 동의 없이 공개 또는 제 3자에게 제공되지 않습니다.</p>
			<a href = "#" target = "_blank">개인정보처리방침</a>
		</span>
	
		<form action = "memberUpdateForm.do" method = "post">
		
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
						<p><br><input type = "text" name = "mName" placeholder = "바꿀 이름 입력."></p>
					</td>
				</tr>
				
				<tr>
					<th>비번 수정</th>
					<td>
						<input type = "password" id = "mPwd" placeholder = "수정할 비밀번호 입력">
						<p><br>
							<input type = "password" name = "iPwd" id = "iPwd" placeholder = "비밀번호 재입력">
							<button type = "button" id = "pwdCheck" onclick = "checkThePwd()">확인</button>
						</p>
					</td>
				</tr>
				
				<tr>
				<th>전번</th>
					<td>
						${vo.phone }<br><br>
						<select id = "localPhoneNumber" name = "localPhoneNumber" style = "width : 150px;">
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
						<input type = "text" name = "mail" maxlength="50"> @ 
						<!-- <input type = "text" name = "email" id = "email" value ="" readonly> -->
						<select id = "localEmail" name = "localEmail" style = "width : 150px;">
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
						<p><br><input type = "text" name = "addr"></p>
					</td>
				</tr>
			</table>
			<div class = "btn_group">
				<input type = "submit" value = "수정" id = "submitBtn">
			</div>
		</form>
	</div>
</body>
</html>