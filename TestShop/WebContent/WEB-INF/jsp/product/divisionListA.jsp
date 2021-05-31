<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
	function divisionInfo(division){
	// 아직 값 안 받아 와짐.		
		
		$.ajax({
			url : 'goDesc.do',
			data : {
				division: division,
			},
			success : function(resp){
				location.href = "productListDesc.do"
			},
			error : function(err){
				console.log(err);
			}
		});
	}
	
	function addCart(itemCode){
		$.ajax({
			url: 'addCart.do',
			data : {
				itemCode : itemCode,
				id : '${id}'
			},
			success : function(resp){
				location.href = "divisionListA.do"
			},
			error : function(err){
				console.log(err);
			}
		});
	}
</script>

<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div class = "row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<c:forEach items = "${list }" var = "list">
				<div class = "col mb-5">
					<div class = "card h-100">
						<!-- 뱃찌 -->
						<div class = "badge bg-dark text-white position-absolute" style = "top: 0.5rem; right : 0.5rem">
							Sale
						</div>
						
						<!-- 상품 이미지 -->
						<img class = "card-img-top" src = "upload/${list.itemImage }" alt = "..." width = "300px" height = "180px" />
						
						<!-- 상품 상세 -->
						<div class = "card-body p-4">
							<div class = "text-center">
								<!-- 상품 이름 -->
								<h5 class = "fw-bolder">${list.itemName }</h5>
								
								<!-- 상품 후기 -->
								<div class = "d-flex justify-content-center small text-warning mb-2">
									<div class = "bi-star-fill">${list.likeIt }</div>
								</div>
								
								<!-- 상품 가격 -->
								<c:if test = "${list.sale eq 'Y' }">
									<span class = "text-muted text-decoration-line-through">
										<fmt:formatNumber type = "currency" value = "${list.price }"></fmt:formatNumber>
									</span>
									&nbsp;
								</c:if>
								<fmt:formatNumber type = "currency" value = "${list.salePrice }"></fmt:formatNumber>
							</div>
						</div>
						
						<!-- 클릭 액션 -->
						<div class = "card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class = "text-center">
								<a class = "btn btn-outline-dark mt-auto" onclick = "divisionInfo('${cateA }')">
									View options
								</a>
							</div>
						</div>
						
						<!-- 클릭 액션 -->
						<div class = "card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class = "text-center">
								<a class ="btn btn-outline-dark mt-auto" onclick="addCart('${list.itemCode }')">
									Add to cart
								</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</section>