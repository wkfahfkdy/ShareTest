<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>

<script>
	
	function formCheck() {
		
		let data = document.getElementsByName('asd')[0].value;
		console.log(data);
		let data2 = document.getElementsByName('confirmText')[0].value;
		console.log(data2);
		
		if(data != data2){
			
			alert('다시 입력');
			return false;
		} else {
			
			alert('잘 가');
			frm.submit();
		}
		
	}
</script>


</head>

<!-- 
1. 우선 회원 본인 확인을 위해 아이디와 비밀번호 입력받기.
2. 입력받으면 그제야 탈퇴 창으로 이동.
3. 탈퇴 문구 입력시킨 뒤 값이 동일하면 탈퇴 처리, 같지 않으면 false.
3-1. 탈퇴 처리 완료 시 index.do로 이동. 
-->


<body>
	<div class = "escapeCheckWindow">
		<div align = "center">
			
			<h3><Strong>화면에 출력된 글자를 입력해 주세요.</Strong></h3>
		
			<form id = "frm" action = "memberDelete.do" method = "post">
				<div class = showWindow">
					${id } 삭제함.
					<input type = "hidden" name = "asd" value = "${id } 삭제함.">
				</div>
				<div class = "inputValue">
					<input type = "text" name = "confirmText">
				</div>
				<div class = "buttonCollect">
					<button type = "button" onclick = "formCheck()">확인</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
