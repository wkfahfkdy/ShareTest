package com.shop.revBoard.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.common.DAO;
import com.shop.revBoard.service.RevBoardService;
import com.shop.revBoard.vo.RevBoardVO;


public class RevBoardServiceImpl extends DAO implements RevBoardService {

	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 페이징
	public List<RevBoardVO> revBoardListPaging(int page){
	
		sql = "select r.* from "
				+ "(select rownum rn, a.* "
				+ "from (select * from rev_board where title not like '%(deadcode:1234)%' order by 1 desc) a) r "
				+ "where r.rn between ? and ?";
		
		List<RevBoardVO> list = new ArrayList<>();
		
		int firstCnt = 0, lastCnt = 0;
		firstCnt = (page - 1) * 10 + 1;
		lastCnt = (page * 10);
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, firstCnt);
			psmt.setInt(2, lastCnt);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				
				RevBoardVO vo = new RevBoardVO();
				
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setId(rs.getInt("id"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				
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
	public List<RevBoardVO> selectRevBoardList() {
		// 전체 리뷰 조회
		
		sql = "select * from rev_board where title not like '%(deadcode:1234)%' order by 1 desc";
		List<RevBoardVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				RevBoardVO vo = new RevBoardVO();
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setId(rs.getInt("id"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				
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
	public RevBoardVO selectRevBoard(RevBoardVO vo) {
		// 하나 조회
		
		sql = "select * from rev_board where id = ?";
		
		 try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				
				hitCount(vo.getId());
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setLikeIt(rs.getInt("like_it"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		 
		return vo;
	}

	@Override
	public int insertRevBoard(RevBoardVO vo) {
		// 입력
		
		int result = 0;
		sql = "insert into rev_board values(rev_board_seq.nextval, ?, ?, ?, ?, sysdate, 0)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setInt(4, vo.getLikeIt());
			
			result = psmt.executeUpdate();
			
			if (result != 0) {
				System.out.println(result + "건 입력");
			} else {
				System.out.println("입력 ㄴㄴ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return 0;
	}

	@Override
	public int updateRevBoard(RevBoardVO vo) {
		// 수정
		
		int result = 0;
		sql = "update rev_board set title = ?, content = ?, like_it = ? where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getLikeIt());
			psmt.setInt(4, vo.getId());
			
			result = psmt.executeUpdate();
			
			if (result != 0) {
				System.out.println(result + "건 수정");
			} else {
				System.out.println("수정 ㄴㄴ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	@Override
	public int deleteRevBoard(RevBoardVO vo) {
		// 삭제
		
		int result = 0;
		sql = "update rev_board set title = title||'(deadcode:1234)' where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			
			result = psmt.executeUpdate();
			
			if (result != 0) {
				System.out.println(result + "건 삭제");
			} else {
				System.out.println("삭제 ㄴㄴ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	// 조회수 증가
	public void hitCount(int id) {
		
		sql = "update rev_board set hit = hit + 1 where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
