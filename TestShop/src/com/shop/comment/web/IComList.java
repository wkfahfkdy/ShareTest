package com.shop.comment.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.comment.service.CommentService;
import com.shop.comment.serviceImpl.CommentServiceImpl;
import com.shop.comment.vo.CommentVO;
import com.shop.common.DbCommand;

public class IComList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bno = request.getParameter("bno");
		
		
		CommentService service = new CommentServiceImpl();
		List<CommentVO> list = service.commentList(Integer.parseInt(bno));
		
		request.setAttribute("list", list);
		
		System.out.println(list);
		return "inqBoard/icomListForm.tiles";
	}

}
