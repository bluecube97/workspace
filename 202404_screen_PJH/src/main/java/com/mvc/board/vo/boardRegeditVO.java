package com.mvc.board.vo;

public class boardRegeditVO {
	private int userNo;
	private String brdTitle;
	private String brdMemo;

	public boardRegeditVO() {
		
	}

	public boardRegeditVO(int userNo, String brdTitle, String brdMemo) {
		this.userNo = userNo;
		this.brdTitle = brdTitle;
		this.brdMemo = brdMemo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getBrdTitle() {
		return brdTitle;
	}

	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}

	public String getBrdMemo() {
		return brdMemo;
	}

	public void setBrdMemo(String brdMemo) {
		this.brdMemo = brdMemo;
	}

	@Override
	public String toString() {
		return "boardRegeditVO [userNo=" + userNo + ", brdTitle=" + brdTitle + ", brdMemo=" + brdMemo + "]";
	}

}
