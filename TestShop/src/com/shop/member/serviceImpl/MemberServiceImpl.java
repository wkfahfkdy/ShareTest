package com.shop.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.common.DAO;
import com.shop.member.service.MemberService;
import com.shop.member.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {

	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public MemberVO loginCheck(MemberVO vo) {
		
		sql = "select * from member where id = ? and passwd = ?";
		MemberVO rvo = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				rvo = new MemberVO();
				rvo.setId(rs.getString("id"));
				rvo.setPasswd(rs.getString("passwd"));
				rvo.setAddress(rs.getString("address"));
				rvo.setMail(rs.getString("mail"));
				rvo.setPhone(rs.getString("phone"));
				rvo.setName(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rvo;
	}
	
	public boolean idCheck(String id) {
		boolean check = false;
		
		sql = "select id from member where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				check = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return check;
	}
	
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
	public List<MemberVO> selectMemberList() {
		// TODO 전체 조회
		
		sql = "select * from member where id not like '%(deadcode:1234)%' order by 1 desc";
		
		List<MemberVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
				vo.setMail(rs.getString("mail"));
				vo.setAddress(rs.getString("address"));
				
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
	public MemberVO selectMember(String id) {
		// TODO 하나 조회
		
		sql = "select * from member where id = ?";
		MemberVO vo = new MemberVO();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setId(rs.getString("id"));	// 추가
				vo.setPasswd(rs.getString("passwd"));
				vo.setAddress(rs.getString("address"));
				vo.setMail(rs.getString("mail"));
				vo.setName(rs.getString("name"));
				vo.setPhone(rs.getString("phone"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return vo;
	}

	@Override
	public int insertMember(MemberVO vo) {
		// TODO 멤버 입력
		
		sql = "insert into member values (?, ?, ?, ?, ?, ?)";
		
		int result = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			psmt.setString(3, vo.getPasswd());
			psmt.setString(2, vo.getName());
			psmt.setString(4, vo.getPhone());
			psmt.setString(5, vo.getMail());
			psmt.setString(6, vo.getAddress());
			
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
	public int updateMember(MemberVO vo) {
		// TODO 멤버 정보 수정
		// 회원 정보 수정하는 거면 아이디뿐 아니라 비밀번호도 일치해야 하는 sql문을 짜야 하지 않을까...?
		
		sql = "update member set passwd = ?, name = ?, phone = ?, mail = ?, address = ? where id = ?";
		
		int result = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getPasswd());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPhone());
			psmt.setString(4, vo.getMail());
			psmt.setString(5, vo.getAddress());
			psmt.setString(6, vo.getId());
			
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
	public int deleteMember(MemberVO vo) {
		// TODO 멤버 삭제
		
		sql = "update member set id = id||'(deadcode:1234)' where id = ?";
		// not exist ( select * from inq_board where title = (sdfsdaf)%) 이렇게 뭐 어딘가에 써먹을수도
		int result = 0;
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			
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

}
