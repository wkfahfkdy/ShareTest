package com.shop.member.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.member.serviceImpl.MemberServiceImpl;
import com.shop.member.vo.MemberVO;

@WebServlet("/memberIdCheck")
public class MemberIdCheck extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String referer = request.getHeader("referer");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberServiceImpl service = new MemberServiceImpl();
		
		int cnt = 0;
		
		if (!referer.contains("Join")) {	// 리퍼럴에 'Join'이 포함되지 않을 시 작동. 즉 로그인 회원 정보 확인.
			
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPasswd(pwd);
				
			MemberVO rvo = service.loginCheck(vo);
			
			response.getWriter().print(rvo);
		
		} else {	// 회원 가입
			
			boolean implResult = service.idCheck(id);
			if(implResult == true) cnt = 1;
			
			response.getWriter().print(cnt);
		}
	}

}
