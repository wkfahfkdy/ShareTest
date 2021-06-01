package com.shop.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.DbCommand;
import com.shop.product.service.ProductService;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class DivisionListA implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		
		ProductVO cateA = (ProductVO) session.getAttribute("cateA");		
		String id = request.getParameter("id");
		
		ProductService service = new ProductServiceImpl();
		List<ProductVO> dList = service.selectCategory(cateA);
		
		request.setAttribute("cateA", cateA);
		request.setAttribute("dList", dList);
		request.setAttribute("id", id);
		System.out.println(dList);
		return "product/divisionListA.tiles";
	}
}
