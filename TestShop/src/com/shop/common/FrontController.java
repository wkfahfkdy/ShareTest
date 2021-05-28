package com.shop.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.web.Bulletin;
import com.yedam.bulletin.web.BulletinDelete;
import com.yedam.bulletin.web.BulletinForm;
import com.yedam.bulletin.web.BulletinInsertPage;
import com.yedam.bulletin.web.BulletinList;
import com.yedam.bulletin.web.BulletinListPaging;
import com.yedam.bulletin.web.BulletinUpdate;
import com.yedam.member.web.MemberJoin;
import com.yedam.member.web.MemberJoinForm;
import com.yedam.member.web.MemberLogin;
import com.yedam.member.web.MemberLoginForm;
import com.yedam.member.web.MemberLogout;
import com.yedam.notice.web.Notice;
import com.yedam.notice.web.NoticeDelete;
import com.yedam.notice.web.NoticeForm;
import com.yedam.notice.web.NoticeInsertPage;
import com.yedam.notice.web.NoticeList;
import com.yedam.notice.web.NoticeListPaging;
import com.yedam.notice.web.NoticeUpdate;
import com.yedam.product.web.AddCart;
import com.yedam.product.web.ProductFavList;
import com.yedam.product.web.ProductList;
import com.yedam.product.web.cartList;

public class FrontController extends HttpServlet {
	
	private HashMap<String, DbCommand> map = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		String cpath = req.getContextPath();
		String path = uri.substring(cpath.length());
		DbCommand command = map.get(path);
		String viewPage = command.execute(req, resp);
		
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}
	
}
