<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="index.do">Food Fighter</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <!-- <li class="nav-item"><a class="nav-link active" aria-current="page" href="index.do">홈</a></li> -->
                        <li class="nav-item"><a class="nav-link" href="productList.do">전 품목</a></li>
                        <!-- <li class="nav-item"><a class="nav-link" href="productList.do">전체 상품</a></li> -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">카테고리 별</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                
                                <li><a class="dropdown-item" href="divisionListA.do">쿠키</a></li>
                                <li><a class="dropdown-item" href="divisionListB.do">빵</a></li>
                                <li><a class="dropdown-item" href="divisionListC.do">간편식</a></li>
                                <li><a class="dropdown-item" href="divisionListD.do">음료</a></li>
                            </ul>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="revBoardList.do">후기</a></li>
                        <li class="nav-item"><a class="nav-link" href="inqBoardList.do">문의</a></li>
                    </ul>
                    <form class="d-flex" action = "cartList.do" type="post"><!-- id로 장바구니 조회 ~> cartList.do -->
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="collapsibleNavbar">
							<ul class="navbar-nav">
								<c:if test = "${id eq 'admin' }">
									<li class="nav-item"><a class="nav-link" href="productManage.do">상품 관리</a></li>
								</c:if>
								<c:if test = "${empty id }">
									<li class = "nav-item"><a class = "nav-link">Hi : Guest</a></li>
								</c:if>
								<c:if test = "${!empty id }">
									<li class = "nav-item"><a class = "nav-link">Hi : ${id }</a></li>
								</c:if>
								
                            	<c:if test="${not empty id }">
									<li class="nav-item"><a class="nav-link" href="memberLogOut.do">로그아웃</a></li>
								</c:if>

								<c:if test="${empty id }">
									<li class="nav-item"><a class="nav-link" href="index.do">로그인</a></li>
									<li class="nav-item"><a class="nav-link" href="memberJoinForm.do">회원가입</a></li>
								</c:if>
                            </ul>
                        </div>
                        <input type = "hidden" name = "id" value = ${id }>
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            장바구니
                            <span class="badge bg-dark text-white ms-1 rounded-pill">${cnt }</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>