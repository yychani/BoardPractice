package com.ungken.board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable{
	private int bId;
	private int bType;
	private int bNo;
	private String category;
	private String bTitle;
	private String bContent;
	private String bwriter;
	private int bCount;
	private int refBid;
	private int replyLevel;
	private Date bDate;
	private Date modifyDate;
	private String status;
	public Board() {
		super();
	}
	public Board(int bId, int bType, int bNo, String category, String bTitle, String bContent, String bwriter,
			int bCount, int refBid, int replyLevel, Date bDate, Date modifyDate, String status) {
		super();
		this.bId = bId;
		this.bType = bType;
		this.bNo = bNo;
		this.category = category;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bwriter = bwriter;
		this.bCount = bCount;
		this.refBid = refBid;
		this.replyLevel = replyLevel;
		this.bDate = bDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public int getbType() {
		return bType;
	}
	public void setbType(int bType) {
		this.bType = bType;
	}
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public int getbCount() {
		return bCount;
	}
	public void setbCount(int bCount) {
		this.bCount = bCount;
	}
	public int getRefBid() {
		return refBid;
	}
	public void setRefBid(int refBid) {
		this.refBid = refBid;
	}
	public int getReplyLevel() {
		return replyLevel;
	}
	public void setReplyLevel(int replyLevel) {
		this.replyLevel = replyLevel;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Board [bId=" + bId + ", bType=" + bType + ", bNo=" + bNo + ", category=" + category + ", bTitle="
				+ bTitle + ", bContent=" + bContent + ", bwriter=" + bwriter + ", bCount=" + bCount + ", refBid="
				+ refBid + ", replyLevel=" + replyLevel + ", bDate=" + bDate + ", modifyDate=" + modifyDate
				+ ", status=" + status + "]";
	}
	
}
