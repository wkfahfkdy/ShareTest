package com.shop.notice.service;

import java.util.List;

import com.shop.notice.vo.NoticeVO;

public interface NoticeService {

	List<NoticeVO> selectNoticeList();
	NoticeVO selectNotice();
	public int insertNotice(NoticeVO vo);
	public int updateNotice(NoticeVO vo);
	public int deleteNotice(NoticeVO vo);
}
