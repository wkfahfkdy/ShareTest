<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	th,td {
		text-align: center;
	}
</style>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
	// 게시글 ID로 조회
	function formSubmit(itemCode){
		
		$.ajax({
			url: 'goDesc.do',
			data: {itemCode: itemCode},
			success: function(result){
				location.href="productListDesc.do"
			},
			error: function(err){
				console.log(err);
			}
		});
	}
	
	function cartDelete(itemCode, id) {

		$.ajax({
			url: 'cartDelete.do',
			data: {itemCode: itemCode, id: id},
			success: function(result){
				alert('물품 삭제')
				location.reload();
			},
			error: function(err){
				console.log(err);
			}
		});
	}
	
	function cartDelete(qtySum, itemCode, id) {

		$.ajax({
			url: 'cartUpdate.do',
				// cartUpdate.do 만들지도 않음. 물품 개수 합을 sql로 떼워놨더니 변경하기 힘듬
			data: {qtySum: qtySum, itemCode: itemCode, id: id},
			success: function(result){
				alert('수량 수정')
				location.reload();
			},
			error: function(err){
				console.log(err);
			}
		});
	}
	
	function iamport(){
		//가맹점 식별코드
		IMP.init('imp07808434');
		IMP.request_pay({
		    pg : 'kcp',
		    pay_method : 'card',
		    merchant_uid : 'merchant_' + new Date().getTime(),
		    name : '상품1' , //결제창에서 보여질 이름
		    amount : 100, //실제 결제되는 가격
		    buyer_email : 'iamport@siot.do',
		    buyer_name : '구매자이름',
		    buyer_tel : '010-1234-5678',
		    buyer_addr : '서울 강남구 도곡동',
		    buyer_postcode : '123-456'
		}, function(rsp) {
			console.log(rsp);
		    if ( rsp.success ) {
		    	var msg = '결제가 완료되었습니다.';
		        msg += '고유ID : ' + rsp.imp_uid;
		        msg += '상점 거래ID : ' + rsp.merchant_uid;
		        msg += '결제 금액 : ' + rsp.paid_amount;
		        msg += '카드 승인번호 : ' + rsp.apply_num;
		    } else {
		    	 var msg = '결제에 실패하였습니다.';
		         msg += '에러내용 : ' + rsp.error_msg;
		    }
		    alert(msg);
		});
	}
</script>
</head>
<body>
	<div align="center">
		<form id="frm" action="goDesc.do" method="POST">
			<table>
				<tr>	
					<th></th><th>상품명</th><th>개수</th><th>가격</th><th>구매가</th><th>계</th>
				</tr>
				<c:forEach items="${list }" var="list">
					<tr>
						<td width="100px"><img src = "upload/${list.itemImage }" alt = "..." width = "50px" height = "50px" /></td>
						<td width="100px" onclick="formSubmit('${list.itemCode}')">${list.itemName }</td>
						<td width="100px"><input type="number" value="${list.qtySum }" style="width:30px;"></td>
						<td width="100px"><fmt:formatNumber value="${list.price }" type="currency"></fmt:formatNumber></td>
						<td width="100px"><fmt:formatNumber value="${list.salePrice }" type="currency"></fmt:formatNumber></td>
						<td width="100px"><fmt:formatNumber value="${list.priceSum }" type="currency"></fmt:formatNumber></td>
						<td><button class="btn btn-outline-dark mt-auto" type="button" onclick="cartUpdate('${list.itemCode}', '${list.qtySum}', '${id }')">수정</button></td>
								<!-- 수정 버튼 만드는데 물품 개수 합을 sql로 떼워놨더니 변경하기 힘듬. -->
						<td><button class="btn btn-outline-dark mt-auto" type="button" onclick="cartDelete('${list.itemCode}', '${id }')">삭제</button></td>
					</tr>
				</c:forEach>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="6"></td>
					<td colspan="2">
						<h5>
							총합계 : <fmt:formatNumber value="${fsum }" type="currency"></fmt:formatNumber>
						</h5>
					</td>
				</tr>
				<tr>
					<td colspan="7"></td>
					<td>
						<h5>
							<button class="btn btn-outline-dark mt-auto" type="button" onclick="iamport()">결제</button>
						</h5>
					</td>
				</tr>
			</table><br>
		</form>
	</div>
	<br>
</body>
</html>