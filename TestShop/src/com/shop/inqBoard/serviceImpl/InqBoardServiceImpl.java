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
				+ "from (select * from inq_board order by id) a) i "
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
		
		sql = "select * from inq_board order by 1";
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
	public InqBoardVO selectInqBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertInqBoard(InqBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateInqBoard(InqBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteInqBoard(InqBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
