package com.user.vo;

public class userVO {
	private int userNo;
	private String userId;
	private String userPw;
	private String userNm;
	private String userDept;
	private String userRole;
	private String userEmail;

	public userVO() {
		
	}

	public userVO(int userNo, String userId, String userNm, String userDept, String userRole, String userEmail) {
		this.userNo = userNo;
		this.userId = userId;
		this.userNm = userNm;
		this.userDept = userDept;
		this.userRole = userRole;
		this.userEmail = userEmail;
	}
	
	public userVO(int userNo, String userNm, String userRole) {
		this.userNo = userNo;
		this.userNm = userNm;
		this.userRole = userRole;
	}

	public userVO(String userId, String userPw) {
		this.userId = userId;
		this.userPw = userPw;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
