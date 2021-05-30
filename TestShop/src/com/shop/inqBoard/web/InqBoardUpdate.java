package com.shop.inqBoard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.inqBoard.service.InqBoardService;
import com.shop.inqBoard.serviceImpl.InqBoardServiceImpl;
import com.shop.inqBoard.vo.InqBoardVO;

public class InqBoardUpdate implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 문의 수정
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		InqBoardVO vo = new InqBoardVO();
		vo.setId(Integer.parseInt(id));
		vo.setContent(content);
		vo.setTitle(title);
		
		InqBoardService serv = new InqBoardServiceImpl();
		serv.updateInqBoard(vo);
		
		request.setAttribute("inqBoard", vo);
		return "inqBoardList.do";
	}

}
