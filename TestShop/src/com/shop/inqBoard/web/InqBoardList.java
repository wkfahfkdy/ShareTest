package com.shop.inqBoard.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.inqBoard.service.InqBoardService;
import com.shop.inqBoard.serviceImpl.InqBoardServiceImpl;
import com.shop.inqBoard.vo.InqBoardVO;

public class InqBoardList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 전체 문의 리스트 출력
		
		InqBoardService serv = new InqBoardServiceImpl();
		List<InqBoardVO> list = serv.selectInqBoardList();
		
		request.setAttribute("inqBoard", list);
		
		return "inqBoard/inqBoardList.tiles";
	}

}
