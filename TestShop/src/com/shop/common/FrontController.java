package com.shop.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.cart.web.cartList;
import com.shop.inqBoard.web.InqBoardForm;
import com.shop.inqBoard.web.InqBoardList;
import com.shop.inqBoard.web.InqBoardInsert;
import com.shop.inqBoard.web.InqBoardSelect;
import com.shop.inqBoard.web.InqBoardUpdate;
import com.shop.member.web.MemberDelete;
import com.shop.member.web.MemberJoin;
import com.shop.member.web.MemberJoinForm;
import com.shop.member.web.MemberLogin;
import com.shop.member.web.MemberLogout;
import com.shop.member.web.MemberUpdate;
import com.shop.product.web.AddCart;
import com.shop.product.web.DivisionListA;
import com.shop.product.web.DivisionListB;
import com.shop.product.web.DivisionListC;
import com.shop.product.web.DivisionListD;
import com.shop.product.web.ProductList;
import com.shop.product.web.ProductListDesc;
import com.shop.product.web.ProductManage;
import com.shop.product.web.goDesc;
import com.shop.revBoard.web.RevBoardForm;
import com.shop.revBoard.web.RevBoardInsert;
import com.shop.revBoard.web.RevBoardList;
import com.shop.revBoard.web.RevBoardSelect;
import com.shop.revBoard.web.RevBoardUpdate;

public class FrontController extends HttpServlet {
	
	private HashMap<String, DbCommand> map = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		map.put("/index.do", new Indexpage());
		map.put("/productManage.do", new ProductManage());
		map.put("/fileUpload.do", new FileUpload());
		
		// MEMBER
		map.put("/memberJoin.do", new MemberJoin());
		map.put("/memberJoinForm.do", new MemberJoinForm());
		map.put("/memberLogin.do", new MemberLogin());
		map.put("/memberLogOut.do", new MemberLogout());
		map.put("/memberDelete.do", new MemberDelete());
		map.put("/memberUpdate.do", new MemberUpdate());
		
		// PRODUCT
		map.put("/productList.do", new ProductList());
		map.put("/productListDesc.do", new ProductListDesc());
		map.put("/goDesc.do", new goDesc());
		map.put("/divisionListA.do", new DivisionListA());
		map.put("/divisionListB.do", new DivisionListB());
		map.put("/divisionListC.do", new DivisionListC());
		map.put("/divisionListD.do", new DivisionListD());
		
		// CART
		map.put("/addCart.do", new AddCart());
		map.put("/cartList.do", new cartList());
		
		// REVIEW
		map.put("/revBoardList.do", new RevBoardList());
		map.put("/revBoardForm.do", new RevBoardForm());
		map.put("/revBoardSelect.do", new RevBoardSelect());
		map.put("/revBoardInsert.do", new RevBoardInsert());
		map.put("/revBoardUpdate.do", new RevBoardUpdate());
		
		// INQUIRE
		map.put("/inqBoardList.do", new InqBoardList());
		map.put("/inqBoardForm.do", new InqBoardForm());
		map.put("/inqBoardSelect.do", new InqBoardSelect());
		map.put("/inqBoardInsert.do", new InqBoardInsert());
		map.put("/inqBoardUpdate.do", new InqBoardUpdate());
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
