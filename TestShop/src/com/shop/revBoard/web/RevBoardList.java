package com.shop.revBoard.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;
import com.shop.common.Paging;
import com.shop.revBoard.serviceImpl.RevBoardServiceImpl;
import com.shop.revBoard.vo.RevBoardVO;

public class RevBoardList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 리뷰 리스트 출력 ( 페이징 )
		
				String page = request.getParameter("page");
				if (page == null) page = "1";
				int pageCnt = Integer.parseInt(page);
				
				RevBoardServiceImpl serv = new RevBoardServiceImpl();
				List<RevBoardVO> whole = serv.selectRevBoardList();
				
				serv = new RevBoardServiceImpl();
				List<RevBoardVO> list = serv.revBoardListPaging(pageCnt);
				
				Paging paging = new Paging();
				paging.setPageNo(pageCnt);
				paging.setPageSize(10);
				paging.setTotalCount(whole.size());
				
				request.setAttribute("revBoardList", list);
				request.setAttribute("paging", paging);
				
				return "revBoard/revBoardList.tiles";
	}

}
