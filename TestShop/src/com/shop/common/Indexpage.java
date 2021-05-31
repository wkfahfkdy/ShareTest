package com.shop.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.cart.serviceImpl.CartServiceImpl;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class Indexpage implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		request.setAttribute("id", id);
		
		CartServiceImpl service = new CartServiceImpl();
		int cnt = service.getCnt(id);
		
		ProductServiceImpl service2 = new ProductServiceImpl();
		ProductVO diviCookie = service2.getDiviCookie();
		
		session.setAttribute("cateA", diviCookie);
		session.setAttribute("cnt", cnt);
		
		if(id == null) {
			return "member/memberLoginForm.tiles";
		} else {
			return "member/memberLoginSuccess.tiles";
		}
		
	}

}
