package com.ungken.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.ungken.board.model.dao.BoardDao;
import com.ungken.board.model.vo.Board;
import static com.ungken.common.JDBCTemplate.*;

public class BoardService extends ArrayList<Board> {

	public ArrayList<Board> selectListAll(int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<Board> list = new BoardDao().selectListAll(con, currentPage, limit);

		close(con);
		return list;
	}

	public int listCount() {
		Connection con = getConnection();

		int listCount = new BoardDao().listCount(con);

		close(con);
		return listCount;
	}

	public int searchCategoryCount(int searchCategory) {
		Connection con = getConnection();

		int listCount = new BoardDao().searchCategoryCount(con, searchCategory);

		close(con);

		return listCount;
	}

	public ArrayList<Board> searchCategory(int searchCategory, int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<Board> list = new BoardDao().searchCategory(con, searchCategory, currentPage, limit);

		close(con);

		return list;
	}

	public int searchTitleCount(String searchInput) {
		Connection con = getConnection();

		int listCount = new BoardDao().searchTitleCount(con, searchInput);

		close(con);

		return listCount;
	}

	public ArrayList<Board> searchTitle(String searchInput, int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<Board> list = new BoardDao().searchTitle(con, searchInput, currentPage, limit);

		close(con);

		return list;
	}

	public int searchWriterCount(String searchInput) {
		Connection con = getConnection();

		int listCount = new BoardDao().searchWriterCount(con, searchInput);

		close(con);

		return listCount;
	}

	public ArrayList<Board> searchWriter(String searchInput, int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<Board> list = new BoardDao().searchWriter(con, searchInput, currentPage, limit);

		close(con);

		return list;
	}

	public int searchContentCount(String searchInput) {
		Connection con = getConnection();

		int listCount = new BoardDao().searchContentCount(con, searchInput);

		close(con);

		return listCount;
	}

	public ArrayList<Board> searchContent(String searchInput, int currentPage, int limit) {
		Connection con = getConnection();

		ArrayList<Board> list = new BoardDao().searchContent(con, searchInput, currentPage, limit);

		close(con);

		return list;
	}

	public int insertBoard(Board b) {
		Connection con = getConnection();

		int result = new BoardDao().insertBoard(con, b);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public Board searchBoardDetail(int num, int isUpdate) {
		Connection con = getConnection();

		Board b = new BoardDao().searchBoardDetail(con, num);

		if (b != null) {
			if (isUpdate != 1) {
				int result = new BoardDao().updateViewCount(con, b.getbId());
				if (result > 0) {
					commit(con);
				} else {
					rollback(con);
				}
			}
		}
		close(con);

		return b;
	}

	public int updateBoard(Board b) {
		Connection con = getConnection();

		int result = new BoardDao().updateBoard(con, b);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;
	}

	public int deleteBoard(int bno) {
		Connection con = getConnection();

		int result = new BoardDao().deleteBoard(con, bno);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		return result;
	}

}
