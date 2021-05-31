package com.shop.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.product.service.ProductService;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class ProductList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.selectProductList();
		
		String id = request.getParameter("id");
		String cnt = request.getParameter("cnt");
		
		request.setAttribute("id", id);
		request.setAttribute("list", list);
		request.setAttribute("cnt", cnt);
				
		return "product/productList.tiles";
	}

}
