package com.shop.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;

public class AddCart implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String itemCode = request.getParameter("itemCode");
		
		
		
		return null;
	}

}
