<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
		width: 900px;
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
			return;
			
		} else {
			
			alert('O');
			frm.pwdCheck.value = "checked";
		}
		
	}
	
	function submitBtn(){
		
		let modiPwd = document.getElementsByName('mPwd')[0].value;				// 수정 비번
		let checkPwd = document.getElementsByName('pwdCheck')[0].value;			// 비번 확인 버튼
		let emailWrite = document.getElementsByName('mail')[0].value;			// 입력 이메일
		let emailSelect = document.getElementsByName('localEmail')[0].value;	// 선택 이메일
		let frontNumber = document.getElementsByName('phoneNumber1')[0].value;	// 전번 앞번호
		let backNumber = document.getElementsByName('phoneNumber2')[0].value;	// 전번 뒷번호
		
		if (modiPwd != "" && checkPwd == "unChecked") {
			
			alert('비밀번호 확인 버튼 체크해라');
			frm.iPwd.focus();
			return;
			
		}else if (modiPwd != frm.iPwd.value){
			
			alert('비번이 같지 않다.');
			frm.iPwd.focus();
			frm.pwdCheck.value = "unChecked";
			return;
			
		} else if (modiPwd != frm.iPwd.value && checkPwd == "unChecked"){
			
			alert("비번 한 번 더 체크해라");
			frm.iPwd.focus();
			return;
			
		} else if((frontNumber != "" || backNumber != "") && (frontNumber.length < 4 || backNumber.length < 4)){
		
			alert('수정할 전화번호를 8자리 모두 입력해라.');
			frm.phoneNumber1.focus();
			return;
		
		} else if(emailWrite != "" && emailSelect == '선택'){
			
			alert('이메일 주소 선택해라');
			frm.mail.focus();
			return;
			
		} else {
			
			alert('수정됨\n미입력 정보는 기존값으로 넣어짐');	// 안 돼도 됐다고 함.
			frm.submit();
			
		}
	}
	
	// 주소 api ~>> http://postcode.map.daum.net/guide
	function findPostCode(){
		
		new daum.Postcode({
			
			oncomplete: function(data){
				// 팝업에서 검색 결과 항목을 클릭했을 때 실행할 코드를 작성하는 부분.
				
				// 내려오는 변수가 값이 없는 경우 공백('') 값을 가지므로, 참고하여 분기한다.
				var roadAddress = data.roadAddress;		// 도로명 주소 변수
				var extraRoadAddress = '';				// 참고 항목 변수
				
				// 법정 동명이 있을 경우 추가. 단, 법정리는 제외.
				if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
					
					extraRoadAddress += data.bname;
				}
				
				// 건물명이 있고 공동 주택일 경우 추가
				if (data.buildngName !== '' && data.apartment === 'Y'){
					
					extraRoadAddress += (extraRoadAddress !== ''? ', ' + data.buildingName : data.buildingName);
				}
				
				// 표시할 참고 항목이 있을 경우 괄호까지 추가한 최종 문자열을 만든다.
				if(extraRoadAddress !== ''){
					
					extraRoadAddress = ' (' + extraRoadAddress + ')';
				}
				
				// 우편 번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('postCode').value = data.zonecode;
				document.getElementById('roadAddr').value = roadAddress;
				document.getElementById('bunAddr').value = data.jibunAddress;
				
				// 참고 항목 문자열이 있을 경우 해당 필드에 넣는다.
				if(roadAddr !== ''){
					
					document.getElementById('extraAddr').value = extraRoadAddress;
				} else {
					
					document.getElementById('extraAddr').value = '';
				}
				
				var guideTextBox = document.getElementById("guide");
				
				// 사용자가 '선택 안 함'을 클릭할 경우, 예상 주소라는 표시를 해 준다.
				if(data.autoRoadAddress){
					
					var expRoadAddr = data.autoRoadAddress + extraRoadAddress;
					guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
					guideTextBox.style.display = 'block';
					
				} else if(data.autoJibunAddress) {
					
					var expJibunAddr = data.autoJibunAddress;
					guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
					guideTextBox.style.display = 'block';
					
				} else {
					
					guideTextBox.innerHTML = '';
					guideTextBox.style.display = 'none';
				}
			}
		
		}).open();
	}
	
</script>
<body>

	<h2>내 정보 수정</h2>

	<div align = "center">
	
		<div class="asdf">
			<Strong>${id }</Strong> 님의 정보입니다.<br>
			회원정보는 개인정보처리방침에 따라 안전하게 보호되며, 회원님의 명백한 동의 없이 공개 또는 제 3자에게 제공되지 않습니다.<br>
			<a href = "#" target = "_blank">개인정보처리방침</a>
		</div>
		<br>
		<form name = "frm" action = "memberUpdateForm.do" method = "post">
		
			<input type = "hidden" name = "hiddenPhone" value = "${vo.phone }">
			<input type = "hidden" name = "hiddenName" value = "${vo.name }">
			<input type = "hidden" name = "hiddenMail" value = "${vo.mail }">
			<input type = "hidden" name = "hiddenAddr" value = "${vo.address }">
			<input type = "hidden" name = "hiddenPwd" value = "${vo.passwd }">
			
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
							<button class="btn btn-outline-dark mt-auto" type = "button" name = "pwdCheck" onclick = "checkThePwd()" value = "unChecked">확인</button>
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
						<p><br><!-- <p><br><input type = "text" name = "addr" maxlength = "30"></p> -->
							<input type = "text" id = "postCode" name = "postCode" placeholder = "우편번호">
							<input class="btn btn-outline-dark mt-auto" type = "button" onclick = "findPostCode()" value = "우편번호 찾기"><br>
							<input type = "text" id = "roadAddr" name = "roadAddr" placeholder = "도로명 주소">
							<input type = "text" id = "bunAddr" name = "bunAddr" placeholder = "지번 주소">
							<span id = "guide" style = "color:#999; display:none"></span>
							<input type = "text" id = "detailAddr" name = "detailAddr" placeholder = "상세 주소">
							<input type = "text" id = "extraAddr" name = "extraAddr" placeholder = "참고 항목">
						</p>
					</td>
				</tr>
			</table>
			<div class = "btn_group">
				<input class="btn btn-outline-dark mt-auto" type = "button" value = "수정" onclick = "submitBtn()">
			</div>
		</form>
	</div>
</body>
</html>