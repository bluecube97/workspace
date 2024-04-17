package com.mvc.board.vo;

public class boardSearchVO {
	private int page;
	private String field;
	private String keyword;
	private String dynamicSql;

	public boardSearchVO() {

	}

	public boardSearchVO(int page, String field, String keyword, String dynamicSql) {
		this.page = page;
		this.field = field;
		this.keyword = keyword;
		this.dynamicSql = dynamicSql;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDynamicSql() {
		return dynamicSql;
	}

	public void setDynamicSql(String dynamicSql) {
		this.dynamicSql = dynamicSql;
	}

}
