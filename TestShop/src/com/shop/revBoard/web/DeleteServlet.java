package com.shop.revBoard.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.revBoard.service.RevBoardService;
import com.shop.revBoard.serviceImpl.RevBoardServiceImpl;
import com.shop.revBoard.vo.RevBoardVO;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
		RevBoardVO vo = new RevBoardVO();
		vo.setId(Integer.parseInt(id));
		
		RevBoardService serv = new RevBoardServiceImpl();
		int deleteCnt = serv.deleteRevBoard(vo);
		
		request.setAttribute("revBoard", vo);
		response.getWriter().print(deleteCnt);
	}

}
