package com.shop.comment.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.comment.service.CommentService;
import com.shop.comment.vo.CommentVO;
import com.shop.common.DAO;

public class CommentServiceImpl extends DAO implements CommentService {

	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	@Override
	public List<CommentVO> commentList(int bno) {
		
		sql = "select * from inq_Comment where bno = ?";
		List<CommentVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bno);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CommentVO vo = new CommentVO();
				vo.setBno(rs.getInt("bno"));
				vo.setComment(rs.getString("content"));
				vo.setId(rs.getString("id"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setRno(rs.getInt("rno"));
				vo.setUpddate(rs.getDate("upddate"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}

	@Override
	public CommentVO selectComment(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertComment(CommentVO vo) {
		
		sql = "insert into inq_Comment (rno, bno, id, content) values(icom_seq.nextval, ?, ?, ?)";
		int r = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBno());
			psmt.setString(2, vo.getId());
			psmt.setString(3, vo.getComment());
			r = psmt.executeUpdate();
			
			System.out.println(r + "건 입력");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return r;
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
