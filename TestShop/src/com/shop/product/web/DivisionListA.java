package com.shop.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.product.service.ProductService;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class DivisionListA implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String division = request.getParameter("division");
		String id = request.getParameter("id");
		String 
		
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.selectCategory(division);
		
		request.setAttribute("list", list);
		request.setAttribute("id", id);
		return "product/divisionListA.tiles";
	}

}
