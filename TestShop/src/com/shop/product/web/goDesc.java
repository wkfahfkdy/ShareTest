package com.shop.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.DbCommand;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class goDesc implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String itemCode =  request.getParameter("itemCode");
		
		ProductServiceImpl service = new ProductServiceImpl();
		ProductVO vo = service.goDesc(itemCode);
		
		session.setAttribute("vo", vo);
		
		return "productListDesc.do";
	}

}
