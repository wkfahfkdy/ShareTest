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
		
		sql = "select  A.BNO, A.RNO, A.RNOCH, A.WRITER, LPAD(' ', 2*(level-1)) || A.content as content, A.DEPTH, A.REGDATE, A.UPDDATE, A.DELE, level\r\n"
				+ "from inq_reply A\r\n"
				+ "where bno = ?\r\n"
				+ "start with rnoch = 0\r\n"
				+ "connect by prior rno = rnoch";
		List<CommentVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bno);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CommentVO vo = new CommentVO();
				vo.setBno(rs.getInt("bno"));
				vo.setRno(rs.getInt("rno"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getDate("regdate"));
				vo.setUpddate(rs.getDate("upddate"));
				vo.setDele(rs.getString("dele"));
				vo.setRnoch(rs.getInt("rnoch"));
				vo.setDepth(rs.getInt("depth"));
				
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

	
	// 댓글
	@Override
	public int insertComment(CommentVO vo) {
		
		sql = "insert into inq_reply (rno, bno, writer, content) values(inq_reply_seq.nextval, ?, ?, ?)";
		int r = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBno());
			psmt.setString(2, vo.getWriter());
			psmt.setString(3, vo.getContent());
			r = psmt.executeUpdate();
			
			System.out.println(r + "건 댓글 입력");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return r;
	}
	
	// 대댓글
	@Override
	public int insertCommentNested(CommentVO vo) {
		
		sql = "insert into inq_reply (rno, bno, writer, content, depth, rnoch) values(inq_reply_seq.nextval, ?, ?, 'ㄴ' || ?, ? +1, ?)";
		int r = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBno());
			psmt.setString(2, vo.getWriter());
			psmt.setString(3, vo.getContent());
			psmt.setInt(4, vo.getDepth());
			psmt.setInt(5, vo.getRno());
			r = psmt.executeUpdate();
			
			System.out.println(r + "건 대댓글 입력");
			
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
