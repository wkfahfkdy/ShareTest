package com.shop.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.member.serviceImpl.MemberServiceImpl;

@WebServlet("/memberIdCheck")
public class MemberIdCheck extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		MemberServiceImpl service = new MemberServiceImpl();
		
		int cnt = 0;
		
		if(service.idCheck(id)) {
			cnt = 1;
		};
		
		response.getWriter().print(cnt);
	}

}
