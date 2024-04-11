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

	
	public UserVO(int userNo, String userNm, String userRole) {
		super();
		this.userNo = userNo;
		this.userNm = userNm;
		this.userRole = userRole;
	}


	public UserVO(String userId, String userPass) {
		super();
		this.userId = userId;
		this.userPass = userPass;
	}
	

	public UserVO(int userNo, String userId, String userNm, String userDept, String userRole) {
		this.userNo = userNo;
		this.userId = userId;
		this.userNm = userNm;
		this.userDept = userDept;
		this.userRole = userRole;
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