package com.shop.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.DbCommand;
import com.shop.member.service.MemberService;
import com.shop.member.serviceImpl.MemberServiceImpl;
import com.shop.member.vo.MemberVO;

public class MemberInfoCheck implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String getID = request.getParameter("memberId");
		String getPwd = request.getParameter("memberPwd");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		MemberService checkID = new MemberServiceImpl();
		MemberVO userInfo = checkID.selectMember(id);
		
		if(getID.equals(userInfo.id) && getPwd.equals(userInfo.passwd)) {
			
			session.setAttribute("userInfo", userInfo);
			
			return "member/memberDelete.tiles";
			
		} else {
			
			return "member/memberCheck.tiles";
		}
		
	}

}
