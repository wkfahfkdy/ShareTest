package com.shop.inqBoard.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;

public class InqBoardForm implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 경로 이동용
		
		return "inqBoard/inqBoardForm.tiles";
	}

}
