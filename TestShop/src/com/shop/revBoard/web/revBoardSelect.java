package com.shop.revBoard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.revBoard.service.RevBoardService;
import com.shop.revBoard.serviceImpl.RevBoardServiceImpl;
import com.shop.revBoard.vo.RevBoardVO;

public class revBoardSelect implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 후기 하나 조회
		
		String id = request.getParameter("id");
		
		RevBoardVO vo = new RevBoardVO();
		vo.setId(Integer.parseInt(id));
		
		RevBoardService serv = new RevBoardServiceImpl();
		serv.selectRevBoard(vo);
		
		request.setAttribute("revBoard", vo);
		
		return "revBoard/revBoard.tiles";
	}

}
