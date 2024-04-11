package com.board.session.vo;

public class sessionVO {
	private String userId;
	private String userNm;
	private String userRole;
	private String userDept;

	public sessionVO() {

	}

	public sessionVO(String userId, String userNm, String userRole, String userDept) {
		this.userId = userId;
		this.userNm = userNm;
		this.userRole = userRole;
		this.userDept = userDept;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getUserDept() {
		return userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

}
