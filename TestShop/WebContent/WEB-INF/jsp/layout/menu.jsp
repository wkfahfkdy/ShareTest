<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="#!">군것질거리</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.do">홈</a></li>
				<li><a class="dropdown-item" href="productList.do">전 품목</a></li>
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">카테고리 별</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="#!">대분류1</a></li>
						<li><a class="dropdown-item" href="#!">대분류2</a></li>
						<li><a class="dropdown-item" href="#!">대분류3</a></li>
						<li><a class="dropdown-item" href="#!">대분류4</a></li>
					</ul></li>
				<c:if test="${id ne null }">
				<li class="nav-item"><a class="nav-link" href="memberLoginOut.do">로그아웃</a></li>
				</c:if>
			</ul>
			<c:if test="${id ne null }">
				<form class="d-flex" action="cartList.do">
						<input type="hidden" name="id" value="${id }">
					<button class="btn btn-outline-dark" type="submit">
						${id }님 <i class="bi-cart-fill me-1"></i> 장바구니 
						<span class="badge bg-dark text-white ms-1 rounded-pill">${cnt }</span>
					</button>
				</form>
			</c:if>
		</div>
	</div>
</nav>