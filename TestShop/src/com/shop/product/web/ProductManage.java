package com.shop.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;

public class ProductManage implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 상품 리스트 불러오기, 각 상품 옆
		/* 	
		 * 뭐만들어야하지
		 * 상품 리스트 우선 불러옴
		 * 리스트 옆에 수정 / 삭제 버튼 만들기
		 * 리스트 우측 상단에 추가 버튼 만들기
		*/ 
		
		return "product/productManage.tiles";
	}
}
