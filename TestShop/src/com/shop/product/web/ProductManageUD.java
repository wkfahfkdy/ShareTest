package com.shop.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.product.service.ProductService;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class ProductManageUD implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.selectProductList();
		
		String id = request.getParameter("id");
		
		request.setAttribute("id", id);
		request.setAttribute("list", list);
		
		return "product/productManageUd.tiles";
	}

}
