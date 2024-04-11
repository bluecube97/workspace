package com.user.vo;

public class userListVO {
	private int userNo;
	private String userNm;
	private String userRole;

	public userListVO() {

	}

	public userListVO(int userNo, String userNm, String userRole) {
		this.userNo = userNo;
		this.userNm = userNm;
		this.userRole = userRole;
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

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
