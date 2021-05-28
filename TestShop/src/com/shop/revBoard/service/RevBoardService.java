package com.shop.revBoard.service;

import java.util.List;

import com.shop.revBoard.vo.RevBoardVO;


public interface RevBoardService {

	List<RevBoardVO> selectNoticeList();
	RevBoardVO selectNotice();
	public int insertNotice(RevBoardVO vo);
	public int updateNotice(RevBoardVO vo);
	public int deleteNotice(RevBoardVO vo);
}
