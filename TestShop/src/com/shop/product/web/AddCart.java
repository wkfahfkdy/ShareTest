package com.shop.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.cart.service.CartService;
import com.shop.cart.serviceImpl.CartServiceImpl;
import com.shop.cart.vo.CartVO;
import com.shop.common.DbCommand;

public class AddCart implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String itemCode = request.getParameter("itemCode");
		String id = request.getParameter("id");
		
		CartVO vo = new CartVO();
		vo.setItemCode(itemCode);
		vo.setUserID(id);
		
		CartService service = new CartServiceImpl();
		service.insertCart(vo);
		
		CartServiceImpl service2 = new CartServiceImpl();
		int cnt = service2.getCnt(id);
		
		HttpSession session = request.getSession();
		session.setAttribute("cnt", cnt);
		
		return "productList.do";
	}

}
