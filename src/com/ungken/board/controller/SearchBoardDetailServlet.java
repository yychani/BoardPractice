package com.ungken.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ungken.board.model.service.BoardService;
import com.ungken.board.model.vo.Board;

@WebServlet("/searchBoardDetail.bo")
public class SearchBoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchBoardDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		int isUpdate = 0;
		if(request.getParameter("update") != null) {
			isUpdate = Integer.parseInt(request.getParameter("update"));
		}
		
		Board b = new BoardService().searchBoardDetail(num, isUpdate);
		
		String page = "";
		if(b != null) {
			page = "views/board/boardDetail.jsp";
			
			request.setAttribute("board", b);
		}else {
			page = "views/common/errorPage.jsp";
			
			request.setAttribute("msg", "게시물 상세보기 실패");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
