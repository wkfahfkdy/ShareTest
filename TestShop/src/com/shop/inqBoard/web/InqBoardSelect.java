package com.shop.inqBoard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.inqBoard.service.InqBoardService;
import com.shop.inqBoard.serviceImpl.InqBoardServiceImpl;
import com.shop.inqBoard.vo.InqBoardVO;

public class InqBoardSelect implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 문의 하나(내용) 조회
		
		String id = request.getParameter("bno");
		
		InqBoardVO vo = new InqBoardVO();
		vo.setId(Integer.parseInt(id));
		
		InqBoardService serv = new InqBoardServiceImpl();
		serv.selectInqBoard(vo);
		
		request.setAttribute("inqBoard", vo);
		
		return "inqBoard/inqBoard.tiles";
	}

}
