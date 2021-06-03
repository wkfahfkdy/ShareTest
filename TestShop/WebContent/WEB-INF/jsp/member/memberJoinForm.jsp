<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
				$('#memberId').focus();
				return;
			} 
			console.log($('#memberId'));
			// ID 중복 체크
			
			$.ajax({
				url: 'memberIdCheck',
				data: {id: $('#memberId').val()},
				type: 'post',
				success: function(data){
					console.log(data);
					if(data > 0) {
						alert('아이디가 존재합니다. 다른 아이디를 입력하시오');
						$('memberId').val("");
						$('memberId').focus();
					} else {
						alert('사용 가능한 아이디입니다');
						$('#idCheck').val('checked')
						$('#memberId').focus();
					}
				},
				error: function(err) {
					console.log(err);
				}
			});
		});
		
		// 비밀번호 재확인 체크
		$('#pwdCheck').click(function () {
			if($('#memberPwd').val() != $('#memberPwd2').val()) {
				alert('비밀번호가 같지 않습니다');
				$('#memberPwd').focus();
			} else {
				alert('ㅇㅇ');
				
				frm.pwdCheck.value = "checked";
			}; 
		});

	});
	
	function formCheck() {
		
		// 아이디 관련 체크
		if(frm.memberId.value == "") {
			alert("아이디를 입력하시오");
			frm.memberId.focus();
			return false;
		} else if(frm.idCheck.value == "unChecked"){
			alert("아이디 중복 체크를 하시오");
			return false;
		}
		
		// 비밀번호 관련 체크
		if(frm.memberPwd.value == "") {
			
			alert("비밀번호를 입력하시오");
			frm.memberPwd.focus();
			return false;
			
		} else if (frm.pwdCheck.value == 'nonChecked') {
			
			alert('비밀번호 확인해 봐라.');
			frm.memberPwd2.focus();
			return;
			
		} else if ( memberPwd.value != memberPwd2.value ) {
			
			alert('비번이 같지 않다.');
			memberPwd2.focus();
			pwdCheck.value = "nonChecked";
			
			return;
			
		} else {
			
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
</head>
	<div align="center">
		<h2> 회원 가입 </h2>
	</div>
	<div align="center">
		<form id="frm" action="memberJoin.do" method="post">
			<div>
				<table>
					<tr>
						<th width="150">아이디 : </th>
						<td width="330">
							<input type="text" id="memberId" name="memberId">
							<button type="button" id="idCheck" value="unChecked">중복 체크</button>
						</td>
					</tr>
					<tr>
						<th width="150">이름 : </th>
						<td width="330"><input type="text" id="memberName" name="memberName">
						</td>
					</tr>
					<tr>
						<th width="150">비밀번호 : </th>
						<td width="330"><input type="password" id="memberPwd" name="memberPwd"></td>
						<th width="150">비밀번호 재확인 : </th>
						<td width="330"><input type="password" id="memberPwd2" name="memberPwd2">
						<button type="button" id="pwdCheck" value="nonChecked">확인</button>
						</td>
					</tr>
					<tr>
						<th width="150">연락처 : </th>
						<td width="330"><input type="text" id="memberPhone" name="memberPhone">
						</td>
					</tr>
					<tr>
						<th width="150">이메일 : </th>
						<td width="330"><input type="text" id="memberMail" name="memberMail">
						</td>
					</tr>
					<tr>
						<th width="150">주소 : </th>
						<td><!-- <input type="text" id="memberAddr" name="memberAddr"> -->
							<input type = "text" id = "postCode" name = "postCode" placeholder = "우편번호">
							<input type = "button" onclick = "findPostCode()" value = "우편번호 찾기"><br>
							<input type = "text" id = "roadAddr" name = "roadAddr" placeholder = "도로명 주소">
							<input type = "text" id = "bunAddr" name = "bunAddr" placeholder = "지번 주소">
							<span id = "guide" style = "color:#999; display:none"></span>
							<input type = "text" id = "detailAddr" name = "detailAddr" placeholder = "상세 주소">
							<input type = "text" id = "extraAddr" name = "extraAddr" placeholder = "참고 항목">
						</td>
					</tr>
				</table>
			</div>
			<div>
				<button type="button" onclick="formCheck()">회원가입</button>
				<button type="button" onclick="location.href='index.do'">메인화면</button>
			</div>
		</form>
	</div>
