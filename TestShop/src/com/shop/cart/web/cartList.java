package com.shop.cart.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.cart.serviceImpl.CartServiceImpl;
import com.shop.common.DbCommand;
import com.shop.product.vo.ProductVO;

public class cartList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		CartServiceImpl service = new CartServiceImpl();
		List<ProductVO> list = service.cartList(id);
		
		int fsum = 0;
		CartServiceImpl service2 = new CartServiceImpl();
		fsum = service2.fsum(id);
		
		request.setAttribute("fsum", fsum);
		request.setAttribute("list", list);
		request.setAttribute("id", id);
		
		return "cart/cartList.tiles";
	}

}
