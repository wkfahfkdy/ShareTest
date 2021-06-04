package com.shop.comment.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.comment.service.CommentService;
import com.shop.comment.serviceImpl.CommentServiceImpl;
import com.shop.comment.vo.CommentVO;
import com.shop.common.DbCommand;

public class IComInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String replytext = request.getParameter("replytext");
		String bno = request.getParameter("bno");
		
		CommentVO vo = new CommentVO();
		vo.setWriter(id);
		vo.setContent(replytext);
		vo.setBno(Integer.parseInt(bno));
		
		CommentService service = new CommentServiceImpl();
		service.insertComment(vo);
		
		return "inqBoardSelect.do";
	}

}
