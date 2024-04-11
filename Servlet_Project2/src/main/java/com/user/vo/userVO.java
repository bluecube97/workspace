package com.user.vo;

public class userVO {
	private int userNo;
	private String userID;
	private String userPass;
	private String userNm;
	private String userDept;
	private String userRole;

	public userVO() {

	}

	public userVO(String userID, String userPass) {
		this.userID = userID;
		this.userPass = userPass;
	}

	public userVO(int userNo, String userID, String userNm, String userRole, String userDept) {
		this.userNo = userNo;
		this.userID = userID;
		this.userNm = userNm;
		this.userRole = userRole;
		this.userDept = userDept;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserDept() {
		return userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
