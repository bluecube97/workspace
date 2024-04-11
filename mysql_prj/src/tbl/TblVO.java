package tbl;

public class TblVO {
	private int brdNo;
	private String brdTitle;
	private String brdMemo;

	public TblVO() {
		
	}

	public TblVO(int brdNo, String brdTitle, String brdMemo) {
		this.brdNo = brdNo;
		this.brdTitle = brdTitle;
		this.brdMemo = brdMemo;
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

	public String getBrdMemo() {
		return brdMemo;
	}

	public void setBrdMemo(String brdMemo) {
		this.brdMemo = brdMemo;
	}
	
}
