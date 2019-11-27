package com.ungken.board.model.vo;

public class PageInfo {
	private int startPage;
	private int endPage;
	private int limit;
	private int maxPage;
	private int currentPage;
	public PageInfo() {
		super();
	}
	public PageInfo(int startPage, int endPage, int limit, int maxPage, int currentPage) {
		super();
		this.startPage = startPage;
		this.endPage = endPage;
		this.limit = limit;
		this.maxPage = maxPage;
		this.currentPage = currentPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "PageInfo [startPage=" + startPage + ", endPage=" + endPage + ", limit=" + limit + ", maxPage=" + maxPage
				+ ", currentPage=" + currentPage + "]";
	}
	
}
