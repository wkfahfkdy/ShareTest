package com.shop.inqBoard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.inqBoard.service.InqBoardService;
import com.shop.inqBoard.serviceImpl.InqBoardServiceImpl;
import com.shop.inqBoard.vo.InqBoardVO;

public class inqBoardInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 문의 등록
		
		String writer = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		InqBoardVO vo = new InqBoardVO();
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setTitle(title);
		
		InqBoardService serv = new InqBoardServiceImpl();
		serv.insertInqBoard(vo);
		
		request.setAttribute("inqBoard", vo);
		return "inqBoardList.do";
	}

}
