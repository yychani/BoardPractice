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

@WebServlet(name = "SearchBoardServlet", urlPatterns = { "/searchBoard.bo" })
public class SearchBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchBoard() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String searchCondition = request.getParameter("searchCondition");
    	String searchInput = request.getParameter("searchInput");
    	int searchCategory = Integer.parseInt(request.getParameter("category"));
    	
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
		
		startPage = (((int)((double) currentPage / limit + 0.9)) -1) * 10 + 1;
		
		endPage = startPage + 10 - 1;
		
		
		int searchListCount = 0;
		
		ArrayList<Board> list = null;
		if(searchCondition.equals("category")) {
			searchListCount = new BoardService().searchCategoryCount(searchCategory);
			list = new BoardService().searchCategory(searchCategory, currentPage, limit);
		}else if(searchCondition.equals("title")) {
			searchListCount = new BoardService().searchTitleCount(searchInput);
			list = new BoardService().searchTitle(searchInput, currentPage, limit);
		}else if(searchCondition.equals("writer")) {
			searchListCount = new BoardService().searchWriterCount(searchInput);
			list = new BoardService().searchWriter(searchInput, currentPage, limit);
		}else if(searchCondition.equals("content")) {
			searchListCount = new BoardService().searchContentCount(searchInput);
			list = new BoardService().searchContent(searchInput, currentPage, limit);
		}
		maxPage = (int)((double) searchListCount / limit + 0.9);
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(startPage, endPage, limit, maxPage, currentPage);
		
		String page = "";
		if(list != null) {
			page = "views/board/boardList.jsp";
			
			request.setAttribute("pi", pi);
			request.setAttribute("list", list);
		}else {
			page = "views/common/errorPage.jsp";
			
			request.setAttribute("msg", "게시판 조회 실패");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
