package com.shop.common;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.cart.serviceImpl.CartServiceImpl;

public class Indexpage implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		request.setAttribute("id", id);
		
		CartServiceImpl service = new CartServiceImpl();
		int cnt = service.getCnt(id);
		
		session.setAttribute("cnt", cnt);
		
		if(id == null) {
			return "member/memberLoginForm.tiles";
		} else {
			return "member/memberLoginSuccess.tiles";
		}
		
	}

}
