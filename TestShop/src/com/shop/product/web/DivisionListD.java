package com.shop.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.product.service.ProductService;
import com.shop.product.serviceImpl.ProductServiceImpl;
import com.shop.product.vo.ProductVO;

public class DivisionListD implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// 분류 : 음료

		ProductVO vo = new ProductVO();
		vo.setDivision("음료");

		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.selectCategory(vo);

		request.setAttribute("list", list);

		return "product/divisionListD.tiles";
		
//		session 수정 전
//		HttpSession session = request.getSession();
//
//		ProductVO cateD = (ProductVO) session.getAttribute("cateD");
//		String id = request.getParameter("id");
//
//		ProductService service = new ProductServiceImpl();
//		List<ProductVO> list = service.selectCategory(cateD);
//
//		request.setAttribute("cateD", cateD);
//		request.setAttribute("list", list);
//		request.setAttribute("id", id);
//		
//		return "product/divisionListD.tiles";
	}

}
