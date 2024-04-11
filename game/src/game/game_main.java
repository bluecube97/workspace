package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class game_main {

	public static void main(String[] args) {
		char_hashmap ch = new char_hashmap();
		List<HashMap<String, Object>> insertCharList = new ArrayList<HashMap<String,Object>>();
		char_make cm = new char_make(); // char_make 클래스 호출
		char_setting cs = new char_setting(); // char_setting 클래스 호출
		char_stat ct = new char_stat();
		roll_dice rdi = new roll_dice();
		game_stat gs = new game_stat();
		game_controll gc = new game_controll();
		monster_stat ms = new monster_stat();
		monster_battle mb = new monster_battle();

		gc.game_progress(insertCharList, ch, cm, cs, rdi, gs, ms, mb);

	}

}
