package com.shop.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.DbCommand;
import com.shop.member.service.MemberService;
import com.shop.member.serviceImpl.MemberServiceImpl;
import com.shop.member.vo.MemberVO;

public class MemberUpdate implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		String modiName = request.getParameter("mName");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(modiName);
		
		
		MemberService service = new MemberServiceImpl();
		vo = service.selectMember(id);
		
		request.setAttribute("vo", vo);
		return "member/memberUpdate.tiles";
	}

}
