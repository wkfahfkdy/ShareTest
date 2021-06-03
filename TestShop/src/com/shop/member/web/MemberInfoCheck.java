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

		String referer = request.getHeader("referer");
		
		String getID = request.getParameter("memberId");
		String getPwd = request.getParameter("memberPwd");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		MemberService checkID = new MemberServiceImpl();
		MemberVO userInfo = checkID.selectMember(id);
		
		String path = "";
		
		if(getID.equals(id) && getPwd.equals(userInfo.getPasswd()) && !referer.contains("Update")) {
			
			path = "member/memberDelete.tiles";
			
		} else if(getID.equals(id) && getPwd.equals(userInfo.getPasswd()) && referer.contains("Update")) {
			
			session.setAttribute("vo", userInfo);
			path = "member/memberUpdate.tiles";
			
		} else {
			
			path = "member/memberCheck.tiles";
		}
		
		return path;
	}

}
