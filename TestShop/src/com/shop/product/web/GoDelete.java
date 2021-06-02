package com.shop.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.cart.serviceImpl.CartServiceImpl;
import com.shop.common.DbCommand;
import com.shop.product.service.ProductService;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class GoDelete implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String itemCode =  request.getParameter("itemCode");
		System.out.println(itemCode);
		
		ProductVO vo = new ProductVO();
		vo.setItemCode(itemCode);
		
		ProductService service = new ProductServiceImpl();
		service.deleteProduct(vo);
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		request.setAttribute("id", id);
		
		CartServiceImpl service2 = new CartServiceImpl();
		int cnt = service2.getCnt(id);
		
		session.setAttribute("cnt", cnt);
		
		return "productManageUD.do";
	}

}
