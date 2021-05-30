package com.shop.inqBoard.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.inqBoard.service.InqBoardService;
import com.shop.inqBoard.serviceImpl.InqBoardServiceImpl;
import com.shop.inqBoard.vo.InqBoardVO;

@WebServlet("/inqDeleteServlet")
public class inqDeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public inqDeleteServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		InqBoardVO vo = new InqBoardVO();
		vo.setId(Integer.parseInt(id));
		
		InqBoardService serv = new InqBoardServiceImpl();
		int deleteCnt = serv.deleteInqBoard(vo);
		
		request.setAttribute("inqBoard", vo);
		response.getWriter().print(deleteCnt);
	}

}
