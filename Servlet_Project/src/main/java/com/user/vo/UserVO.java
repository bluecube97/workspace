package com.user.vo;

public class UserVO {
	private int userNo;
	private String userId;
	private String userPass;
	private String userNm;
	private String userDept;
	private String userRole;

	public UserVO() {
	}

	public UserVO(String userId, String userPass) {
		this.userId = userId;
		this.userPass = userPass;
	}

	public UserVO(int userNo, String userNm, String userRole) {
		this.userNo = userNo;
		this.userNm = userNm;
		this.userRole = userRole;
	}
	
	public UserVO(int userNo, String userId, String userNm, String userRole, String userDept) {
		this.userNo = userNo;
		this.userId = userId;
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
	
	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getuserDept() {
		return userDept;
	}
	public void setuserDept(String userDept) {
		this.userDept = userDept;
	}
}
