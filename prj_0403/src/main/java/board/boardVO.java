package board;

import java.util.Date;

public class boardVO {
	private int brdNo;
	private String brdTitle;
	private int userNo;
	private String userNm;
	private Date brdDate;
	private String skey;
	private String soption;

	public boardVO() {

	}

	public boardVO(int brdNo, String brdTitle, int userNo, String userNm, Date brdDate, String skey,
			String soption) {
		this.brdNo = brdNo;
		this.brdTitle = brdTitle;
		this.userNo = userNo;
		this.userNm = userNm;
		this.brdDate = brdDate;
		this.skey = skey;
		this.soption = soption;
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

	public String getSkey() {
		return skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public String getSoption() {
		return soption;
	}

	public void setSoption(String soption) {
		this.soption = soption;
	}

}
