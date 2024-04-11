package report_card;

public class report_user {
	private String name; // 유저 이름
	private int user_key; // 이름 리스트 키밸류

	public report_user() {

	}

	public report_user(String name, int user_key) {
		super();
		this.name = name;
		this.user_key = user_key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUser_key() {
		return user_key;
	}

	public void setUser_key(int user_key) {
		this.user_key = user_key;
	}

}
