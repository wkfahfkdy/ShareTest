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
		
		CommentVO vo = new CommentVO();
		vo.setId(id);
		
		CommentService service = new CommentServiceImpl();
		service.insertComment(vo);
		
		return null;
	}

}
