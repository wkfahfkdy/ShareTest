package com.shop.member.service;

import java.util.List;

import com.shop.member.vo.MemberVO;

public interface MemberService {

	// CRUD
	List<MemberVO> selectMemberList();
	MemberVO selectMember(String id);
	public int insertMember(MemberVO vo);
	public int updateMember(MemberVO vo);
	public int deleteMember(MemberVO vo);
}
