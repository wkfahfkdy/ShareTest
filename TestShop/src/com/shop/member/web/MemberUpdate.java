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
		
		String name = request.getParameter("mName");
		String phone = request.getParameter(
					"localPhoneNumber" + "-" + 
					"phoneNumber1" + "-" +
					"phoneNumber2");
		String mail = request.getParameter("mail" + "localEmail");
		String addr = request.getParameter("addr");
		String pwd = request.getParameter("iPwd");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(name);
		vo.setAddress(addr);
		vo.setMail(mail);
		vo.setPasswd(pwd);
		vo.setPhone(phone);
		
		MemberService service = new MemberServiceImpl();
		vo = service.selectMember(id);
		
		request.setAttribute("vo", vo);
		return "member/memberUpdate.tiles";
	}

}
