package com.ungken.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ungken.board.model.service.BoardService;
import com.ungken.board.model.vo.Board;
import com.ungken.board.model.vo.PageInfo;

@WebServlet("/searchListAll.bo")
public class SearchListAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchListAllServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int startPage;
		int limit;
		int endPage;
		int currentPage;
		int maxPage;
		
		currentPage = 1;

		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		limit = 10;
		
		int listCount = new BoardService().listCount();
				
		maxPage = (int)((double) listCount / limit + 0.9);
		
		startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 + 1;
		
		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(startPage, endPage, limit, maxPage, currentPage);
		
		ArrayList<Board> list = new BoardService().selectListAll(currentPage, limit);
		
		String page = "";
		if(list != null) {
			page = "views/board/boardList.jsp";
			
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
		}else {
			page = "views/common/errorPage.jsp";
			
			request.setAttribute("msg", "게시판 검색 실패");
		}
		request.getRequestDispatcher(page).forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
