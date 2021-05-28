package com.shop.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.member.service.MemberService;
import com.shop.member.serviceImpl.MemberServiceImpl;
import com.shop.member.vo.MemberVO;

public class MemberJoin implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("memberId");
		String pwd = request.getParameter("memberPwd");
		String name = request.getParameter("memberName");
		String phone = request.getParameter("memberPhone");
		String addr = request.getParameter("memberAddr");
		String mail = request.getParameter("memberMail");
		
		MemberVO vo = new MemberVO();
		
		vo.setId(id);
		vo.setName(name);
		vo.setPasswd(pwd);
		vo.setPhone(phone);
		vo.setAddress(addr);
		vo.setMail(mail);
		
		MemberService serivce = new MemberServiceImpl();
		
		serivce.insertMember(vo);
		
		session.setAttribute("member", vo);
		
		return "main/main.tiles";
	}

}
