package com.shop.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.DbCommand;
import com.shop.member.service.MemberService;
import com.shop.member.serviceImpl.MemberServiceImpl;
import com.shop.member.vo.MemberVO;

public class MemberInformation implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		// MemberUpdate.java 파일이랑 같은데? 모듈화 안 되나??  ~> referer 경로 때문에 안 될 것 같다.
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		MemberService checkID = new MemberServiceImpl();
		MemberVO userInfo = checkID.selectMember(id);
		
		session.setAttribute("userInfo", userInfo);
		
		return "member/memberCheck.tiles";
	}

}
