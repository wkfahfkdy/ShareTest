package com.shop.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.inqBoard.web.InqBoardList;
import com.shop.member.web.MemberJoin;
import com.shop.member.web.MemberJoinForm;
import com.shop.member.web.MemberLogin;
import com.shop.member.web.MemberLogout;
import com.shop.product.web.ProductList;
import com.shop.product.web.ProductListDesc;
import com.shop.product.web.goDesc;
import com.shop.revBoard.web.revBoardDelete;
import com.shop.revBoard.web.revBoardForm;
import com.shop.revBoard.web.revBoardInsert;
import com.shop.revBoard.web.revBoardList;
import com.shop.revBoard.web.revBoardSelect;
import com.shop.revBoard.web.revBoardUpdate;

public class FrontController extends HttpServlet {
	
	private HashMap<String, DbCommand> map = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		map.put("/index.do", new Indexpage());
		
		// MEMBER
		map.put("/memberJoin.do", new MemberJoin());
		map.put("/memberJoinForm.do", new MemberJoinForm());
		map.put("/memberLogin.do", new MemberLogin());
		map.put("/memberLogOut.do", new MemberLogout());
		
		// PRODUCT
		map.put("/productList.do", new ProductList());
		map.put("/productListDesc.do", new ProductListDesc());
		map.put("/goDesc.do", new goDesc());
		
		// REVIEW
		map.put("/revBoardList.do", new revBoardList());
		map.put("/revBoardSelect.do", new revBoardSelect());
		map.put("/revBoardForm.do", new revBoardForm());
		map.put("/revBoardInsert.do", new revBoardInsert());
		map.put("/revBoardUpdate.do", new revBoardUpdate());
		map.put("/revBoardDelete.do", new revBoardDelete());
		
		// INQUIRE
		map.put("/inqBoardList.do", new InqBoardList());
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
