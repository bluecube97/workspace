package game;

public class char_stat {
	private String p_name;
	private int p_job; // 플레이어 직업
	private int p_hp; // 플레이어 체력
	private int p_weapon; // 플레이어 무기
	private String weapon_name; // 플레이어 직업
	private int weapon_dice; // 플레이어 공격력 주사위
	private int p_str; // 플레이어의 힘
	private int p_dex; // 플레이어의 민첩성
	private int p_int; // 플레이어의 지력
	private int p_attk; // 플레이어의 공격력
	private int p_lv = 1; // 플레이어의 레벨

	public char_stat() {

	}

	public char_stat(String p_name, int p_job, int p_hp, int p_weapon, String weapon_name, int weapon_dice, int p_str,
			int p_dex, int p_int, int p_attk, int p_lv) {
		this.p_name = p_name;
		this.p_job = p_job;
		this.p_hp = p_hp;
		this.p_weapon = p_weapon;
		this.weapon_name = weapon_name;
		this.weapon_dice = weapon_dice;
		this.p_str = p_str;
		this.p_dex = p_dex;
		this.p_int = p_int;
		this.p_attk = p_attk;
		this.p_lv = p_lv;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_job() {
		return p_job;
	}

	public void setP_job(int p_job) {
		this.p_job = p_job;
	}

	public int getP_hp() {
		return p_hp;
	}

	public void setP_hp(int p_hp) {
		this.p_hp = p_hp;
	}

	public int getP_weapon() {
		return p_weapon;
	}

	public void setP_weapon(int p_weapon) {
		this.p_weapon = p_weapon;
	}

	public String getWeapon_name() {
		return weapon_name;
	}

	public void setWeapon_name(String weapon_name) {
		this.weapon_name = weapon_name;
	}

	public int getWeapon_dice() {
		return weapon_dice;
	}

	public void setWeapon_dice(int weapon_dice) {
		this.weapon_dice = weapon_dice;
	}

	public int getP_str() {
		return p_str;
	}

	public void setP_str(int p_str) {
		this.p_str = p_str;
	}

	public int getP_dex() {
		return p_dex;
	}

	public void setP_dex(int p_dex) {
		this.p_dex = p_dex;
	}

	public int getP_int() {
		return p_int;
	}

	public void setP_int(int p_int) {
		this.p_int = p_int;
	}

	public int getP_attk() {
		return p_attk;
	}

	public void setP_attk(int p_attk) {
		this.p_attk = p_attk;
	}

	public int getP_lv() {
		return p_lv;
	}

	public void setP_lv(int p_lv) {
		this.p_lv = p_lv;
	}

}
