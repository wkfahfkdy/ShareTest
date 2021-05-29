package com.shop.inqBoard.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.common.Paging;
import com.shop.inqBoard.serviceImpl.InqBoardServiceImpl;
import com.shop.inqBoard.vo.InqBoardVO;

public class InqBoardList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 전체 문의 리스트 출력 ( + 페이징 )
		
		String page = request.getParameter("page");
		if (page == null) page = "1";
		
		int pageCnt = Integer.parseInt(page);
		
		InqBoardServiceImpl serv = new InqBoardServiceImpl();
		List<InqBoardVO> whole = serv.selectInqBoardList();
		
		serv = new InqBoardServiceImpl();
		List<InqBoardVO> list = serv.inqBoardListPaging(pageCnt);
		
		Paging paging = new Paging();
		paging.setPageNo(pageCnt);
		paging.setPageSize(10);
		paging.setTotalCount(whole.size());
		
		request.setAttribute("inqBoardList", list);
		request.setAttribute("paging", paging);
		
		return "inqBoard/inqBoardList.tiles";
	}

}
