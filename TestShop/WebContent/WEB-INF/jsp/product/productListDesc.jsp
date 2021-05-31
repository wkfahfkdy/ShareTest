<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function addCart(itemCode) {
		$.ajax({
			url: 'addCart.do',
			data: {
				itemCode: itemCode,
				id: '${id }'
			},
			success: function(result){
				location.href="productListDesc.do"
			},
			error: function (err){
				console.log(err);
			}
		});
	}
	</script>
<body>
	<section class="py-5">
		<div class="container px-4 px-lg-5 my-5">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					<img class="card-img-top mb-5 mb-md-0" src="upload/${vo.itemImage }">
				</div>
				<div class="col-md-6">
					<div class="small mb-1">${vo.itemCode }</div>
					<h1 class="display-5 fw-bolder">${vo.itemName }</h1>
					<div class="fs-5 ms-5">
						<c:if test="${vo.sale eq 'Y' }">
							<span class="text-decoration-line-through"><fmt:formatNumber type="currency" value="${vo.price }"></fmt:formatNumber></span>
						</c:if>
						<span><fmt:formatNumber type="currency" value="${vo.salePrice }"></fmt:formatNumber></span>
					</div>
					<p class="lead">
						${vo.itemDesc } <br>
						<!-- 설명 늘릴려고 적은것. 나중에 지우기 -->
						safsdafdfsafsa <br>
						sdafsfsf <br>
						sdaf <br>
						sdaf <br>
						safsdafsdafsdaf <br>
						sdafsdafsafsfsdafsdaf <br>
						sdfsafafdf <br>
						sdafsdafasdfsdafsdafsafsdafsdafsdafsdafsdafsfsfsdafsdfsdafsafd <br>
						safsdafsdfsdafsdafsdafsafaadsf <br>
					</p>
					<div class="d-flex">
						<input class="form-control text-center me-3" id="inputQuantity" type="number" value="1" style="max-width: 3rem">
						<button class="btn btn-outline-dark flex-shrink-0" type="button">
							<i class="bi-cart-fill me-1"
								<c:if test="${id ne null }">
									onclick="addCart('${vo.itemCode }')"
								</c:if>
								<c:if test="${id eq null }">
									onclick="productAlert()"
								</c:if>
								>
								Add to cart 
							</i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>