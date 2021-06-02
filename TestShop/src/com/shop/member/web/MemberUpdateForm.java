package com.shop.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.common.DbCommand;
import com.shop.member.service.MemberService;
import com.shop.member.serviceImpl.MemberServiceImpl;
import com.shop.member.vo.MemberVO;

public class MemberUpdateForm implements DbCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		String name = request.getParameter("mName");
		
		String localPhone = request.getParameter("localPhoneNumber");
		String phoneNumber1 = request.getParameter("phoneNumber1");
		String phoneNumber2 = request.getParameter("phoneNumber2");
		String phone = localPhone + "-" + phoneNumber1 + "-" + phoneNumber2;
		
		String mail = request.getParameter("mail");
		String localEmail = request.getParameter("localEmail");
		String fullEmail = mail + localEmail;

		String addr = request.getParameter("addr");
		String passwd = request.getParameter("iPwd");
		
		if (name.equals("")) {
			name = request.getParameter("hiddenName");
		}
		
		if (phoneNumber1.equals("") || phoneNumber2.equals("")) {
			phone = request.getParameter("hiddenPhone");
		}
		
		if (mail.equals("") || localEmail.equals("선택")) {
			fullEmail = request.getParameter("hiddenMail");
		}
		
		if (addr.equals("")) {
			addr = request.getParameter("hiddenAddr");
		}
		
		if (passwd.equals("")) {
			passwd = request.getParameter("hiddenPwd");
		}
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(name);
		vo.setAddress(addr);
		vo.setMail(fullEmail);
		vo.setPasswd(passwd);
		vo.setPhone(phone);
		
		MemberService service = new MemberServiceImpl();
		int result = 0;
		result = service.updateMember(vo);
		
		System.out.println(result + "건 수정");
		System.out.println(vo.toString());
		return "index.do";
	}

	
}
