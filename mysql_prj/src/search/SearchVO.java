package search;

public class SearchVO {

	private String brdTitle;
	private String brdMemo;
	private String userNm;

	public SearchVO() {

	}

	public SearchVO(String brdTitle, String brdMemo, String userNm) {
		this.brdTitle = brdTitle;
		this.brdMemo = brdMemo;
		this.userNm = userNm;
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

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

}
