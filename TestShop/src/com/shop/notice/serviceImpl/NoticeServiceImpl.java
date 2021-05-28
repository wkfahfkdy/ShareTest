package com.shop.notice.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.shop.common.DAO;
import com.shop.notice.service.NoticeService;
import com.shop.notice.vo.NoticeVO;

public class NoticeServiceImpl extends DAO implements NoticeService {

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
	public List<NoticeVO> selectNoticeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeVO selectNotice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
