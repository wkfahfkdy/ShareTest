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
