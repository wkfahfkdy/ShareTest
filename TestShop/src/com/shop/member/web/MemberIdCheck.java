package com.shop.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.member.serviceImpl.MemberServiceImpl;
import com.shop.member.vo.MemberVO;

@WebServlet("/memberIdCheck")
public class MemberIdCheck extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String referer = request.getHeader("referer");
		
		System.out.println("어디서 왔냐 :" + referer);
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberServiceImpl service = new MemberServiceImpl();
		
		int cnt = 0;
		
//		if(service.idCheck(id)) {
//			cnt = 1;
//		};
		MemberVO vo = new MemberVO();
		if (referer.contains("index")) {
			
			vo.setId(id);
			vo.setPasswd(pwd);
			
			vo = service.loginCheck(vo);
			
			response.getWriter().print(vo);
		}
		
		if (referer.contains("Join")) {
			
			boolean implResult = service.idCheck(id);
			if(implResult == true) cnt = 1;
			
			response.getWriter().print(cnt);
			
		}
	}

}
