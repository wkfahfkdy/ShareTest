package com.shop.inqBoard.service;

import java.util.List;

import com.shop.inqBoard.vo.InqBoardVO;


public interface InqBoardService {

	List<InqBoardVO> inqBoardListPaging(int page);
	InqBoardVO selectInqBoard();
	public int insertInqBoard(InqBoardVO vo);
	public int updateInqBoard(InqBoardVO vo);
	public int deleteInqBoard(InqBoardVO vo);
}
