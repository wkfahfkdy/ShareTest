package com.shop.inqBoard.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.shop.common.DAO;
import com.shop.revBoard.service.RevBoardService;
import com.shop.revBoard.vo.RevBoardVO;

public class InqBoardServiceImpl extends DAO implements RevBoardService {

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
	public List<RevBoardVO> selectNoticeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RevBoardVO selectNotice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertNotice(RevBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateNotice(RevBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNotice(RevBoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
