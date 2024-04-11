package com.session.vo;

import java.util.Date;

public class SessionVO {

	private String userId;
	private String userNm;
	private String userRole;
	private String userDept;
	
	public SessionVO() {

	}
	
	public SessionVO(String userId, String userNm, String userRole, String userDept) {

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
