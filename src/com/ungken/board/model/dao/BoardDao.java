package com.ungken.board.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.ungken.board.model.vo.Board;
import static com.ungken.common.JDBCTemplate.*;
public class BoardDao {
	Properties prop = new Properties();
	
	
	public BoardDao() {
		String fileName = BoardDao.class.getResource("/sql/board/board-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public ArrayList<Board> selectListAll(Connection con, int currentPage, int limit) {
		ArrayList<Board> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectListAll");
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			if(rset != null) {
				list = new ArrayList<>();
				
				while(rset.next()) {
					Board b = new Board();
					b.setbId(rset.getInt("BID"));
					b.setbType(rset.getInt("BTYPE"));
					b.setbNo(rset.getInt("RNUM"));
					b.setCategory(rset.getString("CNAME"));
					b.setbTitle(rset.getString("BTITLE"));
					b.setbContent(rset.getString("BCONTENT"));
					b.setBwriter(rset.getString("NICK_NAME"));
					b.setbCount(rset.getInt("BCOUNT"));
					b.setRefBid(rset.getInt("REF_BID"));
					b.setReplyLevel(rset.getInt("REPLY_LEVEL"));
					b.setbDate(rset.getDate("BDATE"));
					b.setModifyDate(rset.getDate("MODIFY_DATE"));
					b.setStatus(rset.getString("STATUS"));
					
					list.add(b);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}


	public int listCount(Connection con) {
		ResultSet rset = null;
		Statement stmt = null;
		int listCount = 0;
		
		String query = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return listCount;
	}


	public int searchCategoryCount(Connection con, int searchCategory) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		int searchListCount = 0;
		
		String query = prop.getProperty("searchCategoryCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, searchCategory);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				searchListCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return searchListCount;
	}


	public ArrayList<Board> searchCategory(Connection con, int searchCategory, int currentPage, int limit) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("searchCategory");
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, searchCategory);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			if(rset != null) {
				list = new ArrayList<>();
				while(rset.next()) {
					Board b = new Board();

					b.setbId(rset.getInt("BID"));
					b.setbType(rset.getInt("BTYPE"));
					b.setbNo(rset.getInt("RNUM"));
					b.setCategory(rset.getString("CNAME"));
					b.setbTitle(rset.getString("BTITLE"));
					b.setbContent(rset.getString("BCONTENT"));
					b.setBwriter(rset.getString("NICK_NAME"));
					b.setbCount(rset.getInt("BCOUNT"));
					b.setRefBid(rset.getInt("REF_BID"));
					b.setReplyLevel(rset.getInt("REPLY_LEVEL"));
					b.setbDate(rset.getDate("BDATE"));
					b.setModifyDate(rset.getDate("MODIFY_DATE"));
					b.setStatus(rset.getString("STATUS"));
					
					list.add(b);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}


	public int searchTitleCount(Connection con, String searchInput) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		int searchListCount = 0;
		
		String query = prop.getProperty("searchTitleCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchInput);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				searchListCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return searchListCount;
	}


	public ArrayList<Board> searchTitle(Connection con, String searchInput, int currentPage, int limit) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("searchTitle");
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchInput);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			if(rset != null) {
				list = new ArrayList<>();
				while(rset.next()) {
					Board b = new Board();

					b.setbId(rset.getInt("BID"));
					b.setbType(rset.getInt("BTYPE"));
					b.setbNo(rset.getInt("RNUM"));
					b.setCategory(rset.getString("CNAME"));
					b.setbTitle(rset.getString("BTITLE"));
					b.setbContent(rset.getString("BCONTENT"));
					b.setBwriter(rset.getString("NICK_NAME"));
					b.setbCount(rset.getInt("BCOUNT"));
					b.setRefBid(rset.getInt("REF_BID"));
					b.setReplyLevel(rset.getInt("REPLY_LEVEL"));
					b.setbDate(rset.getDate("BDATE"));
					b.setModifyDate(rset.getDate("MODIFY_DATE"));
					b.setStatus(rset.getString("STATUS"));
					
					list.add(b);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}


	public int searchWriterCount(Connection con, String searchInput) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		int searchListCount = 0;
		
		String query = prop.getProperty("searchWriterCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchInput);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				searchListCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return searchListCount;
	}


	public ArrayList<Board> searchWriter(Connection con, String searchInput, int currentPage, int limit) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("searchWriter");
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchInput);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			if(rset != null) {
				list = new ArrayList<>();
				while(rset.next()) {
					Board b = new Board();

					b.setbId(rset.getInt("BID"));
					b.setbType(rset.getInt("BTYPE"));
					b.setbNo(rset.getInt("RNUM"));
					b.setCategory(rset.getString("CNAME"));
					b.setbTitle(rset.getString("BTITLE"));
					b.setbContent(rset.getString("BCONTENT"));
					b.setBwriter(rset.getString("NICK_NAME"));
					b.setbCount(rset.getInt("BCOUNT"));
					b.setRefBid(rset.getInt("REF_BID"));
					b.setReplyLevel(rset.getInt("REPLY_LEVEL"));
					b.setbDate(rset.getDate("BDATE"));
					b.setModifyDate(rset.getDate("MODIFY_DATE"));
					b.setStatus(rset.getString("STATUS"));
					
					list.add(b);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}


	public int searchContentCount(Connection con, String searchInput) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		int searchListCount = 0;
		
		String query = prop.getProperty("searchContentCount");

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchInput);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				searchListCount = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return searchListCount;
	}


	public ArrayList<Board> searchContent(Connection con, String searchInput, int currentPage, int limit) {
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("searchContent");
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, searchInput);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset = pstmt.executeQuery();
			
			if(rset != null) {
				list = new ArrayList<>();
				while(rset.next()) {
					Board b = new Board();

					b.setbId(rset.getInt("BID"));
					b.setbType(rset.getInt("BTYPE"));
					b.setbNo(rset.getInt("RNUM"));
					b.setCategory(rset.getString("CNAME"));
					b.setbTitle(rset.getString("BTITLE"));
					b.setbContent(rset.getString("BCONTENT"));
					b.setBwriter(rset.getString("NICK_NAME"));
					b.setbCount(rset.getInt("BCOUNT"));
					b.setRefBid(rset.getInt("REF_BID"));
					b.setReplyLevel(rset.getInt("REPLY_LEVEL"));
					b.setbDate(rset.getDate("BDATE"));
					b.setModifyDate(rset.getDate("MODIFY_DATE"));
					b.setStatus(rset.getString("STATUS"));
					
					list.add(b);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		return list;
	}


	public int insertBoard(Connection con, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("insertBoard");
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(b.getCategory()));
			pstmt.setString(2, b.getbTitle());
			pstmt.setString(3, b.getbContent());
			pstmt.setInt(4, Integer.parseInt(b.getBwriter()));

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	public Board searchBoardDetail(Connection con, int num) {
		Board b = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("searchBoardDetail");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board();
				
				b.setbId(rset.getInt("BNO"));
				b.setbType(rset.getInt("BTYPE"));
				b.setbNo(rset.getInt("RNUM"));
				b.setCategory(rset.getString("CNAME"));
				b.setbTitle(rset.getString("BTITLE"));
				b.setbContent(rset.getString("BCONTENT"));
				b.setBwriter(rset.getString("NICK_NAME"));
				b.setbCount(rset.getInt("BCOUNT"));
				b.setRefBid(rset.getInt("REF_BID"));
				b.setReplyLevel(rset.getInt("REPLY_LEVEL"));
				b.setbDate(rset.getDate("BDATE"));
				b.setModifyDate(rset.getDate("MODIFY_DATE"));
				b.setStatus(rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return b;
	}


	public int updateBoard(Connection con, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getbTitle());
			pstmt.setString(2, b.getbContent());
			pstmt.setInt(3, b.getbNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	public int deleteBoard(Connection con, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("deleteBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}


	public int updateViewCount(Connection con, int bNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("updateViewCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bNo);
			pstmt.setInt(2, bNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
