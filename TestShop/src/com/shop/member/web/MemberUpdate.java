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
		
		MemberService service = new MemberServiceImpl();
		MemberVO vo = service.selectMember(id);
		
		session.setAttribute("userInfo", vo);
		// 경로 수정 전에는 MemberInformation.java와 달리 request.setAttribute()로 만족됐었는데, 경로 수정 이후로는 안 됨. session 써야 함.
		
		return "member/memberCheck.tiles";
	}

}
