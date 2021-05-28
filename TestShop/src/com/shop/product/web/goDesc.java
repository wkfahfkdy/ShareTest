package com.shop.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class goDesc implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String itemCode =  request.getParameter("itemCode");
		
		ProductServiceImpl service = new ProductServiceImpl();
		ProductVO vo = service.goDesc(itemCode);
		
		request.setAttribute("vo", vo);
		
		return "productList.do";
	}

}
