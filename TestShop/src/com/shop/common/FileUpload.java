package com.shop.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileUpload implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String photo = request.getParameter("photo");
		String itemCode = request.getParameter("itemCode");
		String itemName = request.getParameter("itemName");
		System.out.println(photo);
		System.out.println(itemCode);
		System.out.println(itemName);
		
		return "productManage.do";
	}

}
