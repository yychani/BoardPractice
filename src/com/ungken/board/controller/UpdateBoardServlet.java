package com.ungken.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ungken.board.model.service.BoardService;
import com.ungken.board.model.vo.Board;

@WebServlet("/updateBoard.bo")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int rnum = Integer.parseInt(request.getParameter("rnum"));
		Board b = new Board();
		b.setbNo(bno);
		b.setbTitle(title);
		b.setbContent(content);
		
		int result = new BoardService().updateBoard(b);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/searchBoardDetail.bo?update=1&num=" + rnum);
		}else {
			request.setAttribute("msg", "게시물 수정 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
