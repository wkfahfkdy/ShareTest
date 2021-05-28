package com.shop.revBoard.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.revBoard.service.RevBoardService;
import com.shop.revBoard.serviceImpl.RevBoardServiceImpl;
import com.shop.revBoard.vo.RevBoardVO;

public class revBoardList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 리뷰 리스트 출력
		
		RevBoardService serv = new RevBoardServiceImpl();
		List<RevBoardVO> list = serv.selectRevBoardList();
		
		request.setAttribute("revBoard", list);
		
		return "revBoard/revBoardList.tiles";
	}

}
