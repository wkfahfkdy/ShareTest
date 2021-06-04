package com.shop.inqBoard.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.comment.service.CommentService;
import com.shop.comment.serviceImpl.CommentServiceImpl;
import com.shop.comment.vo.CommentVO;
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
		
		// 댓글 부르기
		
		String bno = request.getParameter("bno");
		
		CommentService service = new CommentServiceImpl();
		List<CommentVO> list = service.commentList(Integer.parseInt(bno));
		
		request.setAttribute("list", list);
		
		return "inqBoard/inqBoard.tiles";
	}

}
