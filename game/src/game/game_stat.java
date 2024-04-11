package game;

public class game_stat {
	private boolean start_game = true; // 게임 진행 여부
	private boolean character_set = true; // 플레이어 생성 진행 여부
	private int character_set_flag = 0; // 플레이어 생성 진행 flag
	private int character_more_set_flag = 0; // 플레이어 추가 생성 진행 flag
	private boolean tour = true; // 휴식 여부
	private boolean battle = true; // 전투 여부
	private int tour_flag = 0;
	private int battle_flag = 0;

	private int dice_encounter = 6; // 몬스터 조우 확률 주사위
	private int dice_kind = 5; // 몬스터 종류 주사위

	public game_stat() {

	}

	public game_stat(boolean start_game, boolean character_set, int character_set_flag, int character_more_set_flag,
			boolean tour, boolean battle, int tour_flag, int battle_flag, int dice_encounter, int dice_kind) {
		super();
		this.start_game = start_game;
		this.character_set = character_set;
		this.character_set_flag = character_set_flag;
		this.character_more_set_flag = character_more_set_flag;
		this.tour = tour;
		this.battle = battle;
		this.tour_flag = tour_flag;
		this.battle_flag = battle_flag;
		this.dice_encounter = dice_encounter;
		this.dice_kind = dice_kind;
	}

	public boolean isStart_game() {
		return start_game;
	}

	public void setStart_game(boolean start_game) {
		this.start_game = start_game;
	}

	public boolean isCharacter_set() {
		return character_set;
	}

	public void setCharacter_set(boolean character_set) {
		this.character_set = character_set;
	}

	public int getCharacter_set_flag() {
		return character_set_flag;
	}

	public void setCharacter_set_flag(int character_set_flag) {
		this.character_set_flag = character_set_flag;
	}

	public int getCharacter_more_set_flag() {
		return character_more_set_flag;
	}

	public void setCharacter_more_set_flag(int character_more_set_flag) {
		this.character_more_set_flag = character_more_set_flag;
	}

	public boolean isTour() {
		return tour;
	}

	public void setTour(boolean tour) {
		this.tour = tour;
	}

	public boolean isBattle() {
		return battle;
	}

	public void setBattle(boolean battle) {
		this.battle = battle;
	}

	public int getTour_flag() {
		return tour_flag;
	}

	public void setTour_flag(int tour_flag) {
		this.tour_flag = tour_flag;
	}

	public int getBattle_flag() {
		return battle_flag;
	}

	public void setBattle_flag(int battle_flag) {
		this.battle_flag = battle_flag;
	}

	public int getDice_encounter() {
		return dice_encounter;
	}

	public void setDice_encounter(int dice_encounter) {
		this.dice_encounter = dice_encounter;
	}

	public int getDice_kind() {
		return dice_kind;
	}

	public void setDice_kind(int dice_kind) {
		this.dice_kind = dice_kind;
	}

}
