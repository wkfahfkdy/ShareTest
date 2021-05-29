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
				+ "from (select * from rev_board order by id) a) r "
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
		
		sql = "select * from rev_board order by 1";
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
	public RevBoardVO selectRevBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertRevBoard(RevBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRevBoard(RevBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRevBoard(RevBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
