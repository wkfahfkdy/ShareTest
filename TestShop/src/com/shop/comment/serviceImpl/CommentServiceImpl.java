package com.shop.comment.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.shop.comment.service.CommentService;
import com.shop.comment.vo.CommentVO;
import com.shop.common.DAO;

public class CommentServiceImpl extends DAO implements CommentService {

	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	@Override
	public List<CommentVO> commnetList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentVO selectComment(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertComment(CommentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateComment(CommentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteComment(CommentVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void close() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
