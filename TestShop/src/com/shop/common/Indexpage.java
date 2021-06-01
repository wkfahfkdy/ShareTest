package com.shop.common;


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
		
		ProductServiceImpl service3 = new ProductServiceImpl();
		ProductVO diviBread = service3.getDiviBread();
		
		ProductServiceImpl service4 = new ProductServiceImpl();
		ProductVO diviHRM = service4.getDiviHMR();
		
		ProductServiceImpl service5 = new ProductServiceImpl();
		ProductVO diviDrink = service5.getDiviDrink();
		
		session.setAttribute("cateA", diviCookie);
		session.setAttribute("cateB", diviBread);
		session.setAttribute("cateC", diviHRM);
		session.setAttribute("cateD", diviDrink);
		session.setAttribute("cnt", cnt);
		
		if(id == null) {
			return "member/memberLoginForm.tiles";
		} else {
			return "member/memberLoginSuccess.tiles";
		}
		
	}

}
