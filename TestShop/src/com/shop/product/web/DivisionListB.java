package com.shop.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.product.service.ProductService;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class DivisionListB implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// 분류 : 빵
		
		ProductVO vo = new ProductVO();
		vo.setDivision("빵");
		
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.selectCategory(vo);
		
		request.setAttribute("list", list);
		
		return "product/divisionListB.tiles";
	}

}
