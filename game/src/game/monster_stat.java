package game;

public class monster_stat {
	private int monster_encounter = 0; // 몬스터와 조우
	private int monster_kind = 0; // 몬스터의 종

	private String monster_name = ""; // 몬스터 이름
	private int monster_HP = 0; // 몬스터 체력
	private int monster_weapon = 0; // 몬스터 무기
	private String m_weapon_name = ""; // 몬스터 무기명
	private int m_weapon_dice = 0; // 몬스터 공격력 주사위
	private int monster_attk = 0; // 몬스터 공격력
	private int monster_str = 0; // 몬스터 힘
	private int monster_dex = 0; // 몬스터 민첩성
	private int monster_int = 0; // 몬스터 지력
	private int monster_level = 0; // 몬스터 레벨
	private int monster_exp = 0; // 몬스터 처치시 획득 경험치

	public monster_stat() {

	}

	public monster_stat(int monster_encounter, int monster_kind, String monster_name, int monster_HP,
			int monster_weapon, String m_weapon_name, int m_weapon_dice, int monster_attk, int monster_str,
			int monster_dex, int monster_int, int monster_level, int monster_exp) {
		this.monster_encounter = monster_encounter;
		this.monster_kind = monster_kind;
		this.monster_name = monster_name;
		this.monster_HP = monster_HP;
		this.monster_weapon = monster_weapon;
		this.m_weapon_name = m_weapon_name;
		this.m_weapon_dice = m_weapon_dice;
		this.monster_attk = monster_attk;
		this.monster_str = monster_str;
		this.monster_dex = monster_dex;
		this.monster_int = monster_int;
		this.monster_level = monster_level;
		this.monster_exp = monster_exp;
	}

	public int getMonster_encounter() {
		return monster_encounter;
	}

	public void setMonster_encounter(int monster_encounter) {
		this.monster_encounter = monster_encounter;
	}

	public int getMonster_kind() {
		return monster_kind;
	}

	public void setMonster_kind(int monster_kind) {
		this.monster_kind = monster_kind;
	}

	public String getMonster_name() {
		return monster_name;
	}

	public void setMonster_name(String monster_name) {
		this.monster_name = monster_name;
	}

	public int getMonster_HP() {
		return monster_HP;
	}

	public void setMonster_HP(int monster_HP) {
		this.monster_HP = monster_HP;
	}

	public int getMonster_weapon() {
		return monster_weapon;
	}

	public void setMonster_weapon(int monster_weapon) {
		this.monster_weapon = monster_weapon;
	}

	public String getM_weapon_name() {
		return m_weapon_name;
	}

	public void setM_weapon_name(String m_weapon_name) {
		this.m_weapon_name = m_weapon_name;
	}

	public int getM_weapon_dice() {
		return m_weapon_dice;
	}

	public void setM_weapon_dice(int m_weapon_dice) {
		this.m_weapon_dice = m_weapon_dice;
	}

	public int getMonster_attk() {
		return monster_attk;
	}

	public void setMonster_attk(int monster_attk) {
		this.monster_attk = monster_attk;
	}

	public int getMonster_str() {
		return monster_str;
	}

	public void setMonster_str(int monster_str) {
		this.monster_str = monster_str;
	}

	public int getMonster_dex() {
		return monster_dex;
	}

	public void setMonster_dex(int monster_dex) {
		this.monster_dex = monster_dex;
	}

	public int getMonster_int() {
		return monster_int;
	}

	public void setMonster_int(int monster_int) {
		this.monster_int = monster_int;
	}

	public int getMonster_level() {
		return monster_level;
	}

	public void setMonster_level(int monster_level) {
		this.monster_level = monster_level;
	}

	public int getMonster_exp() {
		return monster_exp;
	}

	public void setMonster_exp(int monster_exp) {
		this.monster_exp = monster_exp;
	}

}