package com.shop.inqBoard.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.common.DAO;
import com.shop.inqBoard.service.InqBoardService;
import com.shop.inqBoard.vo.InqBoardVO;

public class InqBoardServiceImpl extends DAO implements InqBoardService {

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
	public List<InqBoardVO> inqBoardListPaging(int page){
		
		sql = "select i.* from "
				+ "(select rownum rn, a.* "
				+ "from (select * from inq_board where title not like '%(deadcode:1234)%' order by id desc) a) i "
				+ "where i.rn between ? and ?";
		
		List<InqBoardVO> list = new ArrayList<>();
		
		int firstCnt = 0, lastCnt = 0;
		firstCnt = (page -1) * 10 + 1;
		lastCnt = (page * 10);
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, firstCnt);
			psmt.setInt(2, lastCnt);
			
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				
				InqBoardVO vo = new InqBoardVO();
				
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
	public List<InqBoardVO> selectInqBoardList() {
		// 전체 문의 출력
		
		sql = "select * from inq_board where title not like '%(deadcode:1234)%' order by 1 desc";
		List<InqBoardVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				InqBoardVO vo = new InqBoardVO();
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
	public InqBoardVO selectInqBoard(InqBoardVO vo) {
		// 하나 조회
		
		sql = "select * from inq_board where id = ?";
		
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
	public int insertInqBoard(InqBoardVO vo) {
		// 입력
		
		int result = 0;
		sql = "insert into inq_board values (inq_board_seq.nextval, ?, ?, ?, ?, sysdate, 0)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setInt(4, vo.getLikeIt());
			
			result = psmt.executeUpdate();
			
			if(result != 0) {
				System.out.println(result + "건 입력");
			} else {
				System.out.println("입력 ㄴㄴ");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}

	@Override
	public int updateInqBoard(InqBoardVO vo) {
		// 수정
		
		int result = 0;
		sql = "update inq_board set title = ?, content = ?, like_it = ? where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setInt(3, vo.getLikeIt());
			psmt.setInt(4, vo.getId());
			
			result = psmt.executeUpdate();
			
			if(result != 0) {
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
	public int deleteInqBoard(InqBoardVO vo) {
		// 삭제
		
		int result = 0;
		sql = "update inq_board set title = title||'(deadcode:1234)' where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			
			result = psmt.executeUpdate();
			
			if(result != 0) {
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
		
		sql = "update inq_board set hit = hit + 1 where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
