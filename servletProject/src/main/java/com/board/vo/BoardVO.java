package com.board.vo;

import java.util.Date;

public class BoardVO {
	private int brdNo;
	private String brdTitle;
	private int userNo;
	private String userNm;
	private String brdMemo;
	private Date brdDate;

	public BoardVO() {
		super();
	}

	public BoardVO(int brdNo, String brdTitle, int userNo, String userNm, Date brdDate) {
		super();
		this.brdNo = brdNo;
		this.brdTitle = brdTitle;
		this.userNo = userNo;
		this.userNm = userNm;
		this.brdDate = brdDate;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getBrdTitle() {
		return brdTitle;
	}

	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public Date getBrdDate() {
		return brdDate;
	}

	public void setBrdDate(Date brdDate) {
		this.brdDate = brdDate;
	}

	public String getBrdMemo() {
		return brdMemo;
	}

	public void setBrdMemo(String brdMemo) {
		this.brdMemo = brdMemo;
	}

}