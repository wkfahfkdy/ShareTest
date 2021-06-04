package com.shop.comment.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.comment.service.CommentService;
import com.shop.comment.serviceImpl.CommentServiceImpl;
import com.shop.comment.vo.CommentVO;
import com.shop.common.DbCommand;

public class NestInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String replytext = request.getParameter("replytext");
		String bno = request.getParameter("bno");
		String depth = request.getParameter("depth");
		String rno = request.getParameter("rno");
		
		CommentVO vo = new CommentVO();
		vo.setWriter(id);
		vo.setContent(replytext);
		vo.setBno(Integer.parseInt(bno));
		vo.setDepth(Integer.parseInt(depth));
		vo.setRno(Integer.parseInt(rno));
		
		System.out.println(vo);
		
		CommentService service = new CommentServiceImpl();
		service.insertCommentNested(vo);
		
		return "inqBoardSelect.do";
	}

}
