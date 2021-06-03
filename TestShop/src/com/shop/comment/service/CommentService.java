package com.shop.comment.service;

import java.util.List;

import com.shop.comment.vo.CommentVO;

public interface CommentService {

	List<CommentVO> commnetList();
	CommentVO selectComment(String id);
	public int insertComment(CommentVO vo);
	public int updateComment(CommentVO vo);
	public int deleteComment(CommentVO vo);
}
