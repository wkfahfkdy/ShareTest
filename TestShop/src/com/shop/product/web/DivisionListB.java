package com.shop.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.DbCommand;
import com.shop.product.service.ProductService;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class DivisionListB implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		ProductVO cateB = (ProductVO) session.getAttribute("cateB");		
		String id = request.getParameter("id");
		
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.selectCategory(cateB);
		
		request.setAttribute("cateB", cateB);
		request.setAttribute("list", list);
		request.setAttribute("id", id);
		
		return "product/divisionListB.tiles";
	}

}
