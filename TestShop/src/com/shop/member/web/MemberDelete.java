package com.shop.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.DbCommand;

public class MemberDelete implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		return "member/memberDelete.tiles";
	}

}
