package com.shop.revBoard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.revBoard.service.RevBoardService;
import com.shop.revBoard.serviceImpl.RevBoardServiceImpl;
import com.shop.revBoard.vo.RevBoardVO;

public class RevBoardInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 후기 등록
		
		String writer = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		RevBoardVO vo = new RevBoardVO();
		vo.setWriter(writer);
		vo.setTitle(title);
		vo.setContent(content);
		
		RevBoardService serv = new RevBoardServiceImpl();
		serv.insertRevBoard(vo);
		
		request.setAttribute("revBoard", vo);
		return "revBoardList.do";
	}

}
