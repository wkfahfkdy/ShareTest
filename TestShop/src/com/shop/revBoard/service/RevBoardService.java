package com.shop.revBoard.service;

import java.util.List;

import com.shop.revBoard.vo.RevBoardVO;


public interface RevBoardService {

	List<RevBoardVO> revBoardListPaging(int page);
	RevBoardVO selectRevBoard();
	public int insertRevBoard(RevBoardVO vo);
	public int updateRevBoard(RevBoardVO vo);
	public int deleteRevBoard(RevBoardVO vo);
}
