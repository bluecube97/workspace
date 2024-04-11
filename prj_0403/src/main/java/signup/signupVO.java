package signup;

public class signupVO {
	private int userNo;
	private String userId;
	private String userPw;
	private String userNm;
	private String userDept;
	private String userRole;
	private String userEmail;
	private String userSex;

	public signupVO() {
		
	}

	public signupVO(int userNo, String userId, String userPw, String userNm, String userDept, String userRole,
			String userEmail, String userSex) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userNm = userNm;
		this.userDept = userDept;
		this.userRole = userRole;
		this.userEmail = userEmail;
		this.userSex = userSex;
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

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

}
