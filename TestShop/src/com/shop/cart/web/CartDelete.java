package com.shop.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.cart.service.CartService;
import com.shop.cart.serviceImpl.CartServiceImpl;
import com.shop.cart.vo.CartVO;
import com.shop.common.DbCommand;

public class CartDelete implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String itemCode = request.getParameter("itemCode");
		String id = request.getParameter("id");
		
		CartService service = new CartServiceImpl();
		CartVO vo = new CartVO();
		vo.setItemCode(itemCode);
		vo.setUserID(id);
		
		service.deleteCart(vo);
		
		return "cartList.do";
	}

}
