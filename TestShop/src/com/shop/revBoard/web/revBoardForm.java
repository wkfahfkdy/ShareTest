package com.shop.revBoard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;

public class revBoardForm implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 후기 등록 페이지로 가는 경로 지정용
		
		return "revBoard/revBoardForm.tiles";
	}

}
