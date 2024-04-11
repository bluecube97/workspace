package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class game_controll {

	public void game_progress(List<HashMap<String, Object>> insertCharList, char_hashmap ch,char_make cm, char_setting cs, roll_dice rdi,
			game_stat gs, monster_stat ms, monster_battle mb) {
		HashMap<String, Object> insertCharMap = insertCharList.get(0);
		// 게임진행 루프
		while (gs.isStart_game()) {
			List<char_stat> csl = new ArrayList<char_stat>();
			// 플레이어 생성 루프 시작
			while (gs.isCharacter_set()) {
				// 플레이어 능력치 설정
				insertCharMap = cm.input_name(insertCharMap, ch); // p_name에 char_make 클래스의 input_name 메서드 호출
				cm.select_job(insertCharList, ch); // p_job에 char_make 클래스의 select_job 메서드 호출
				cs.set_job(insertCharList, ch);
				rdi.info_dice(insertCharList, ch);
				rdi.set_dice(insertCharList, ch, cs);
				rdi.info_stat(insertCharList, ch, gs);
				rdi.create_char_loof_end(insertCharList, ch, gs, csl);*/
			} // 플레이어 생성 루프 종료
			while (gs.isTour()) {
				/*mb.battle_intro(insertCharList, ch, gs, ms);
				mb.battle_phase(insertCharList, ch, gs, ms, cs);
				mb.battle_end(insertCharList, ch, gs, ms, cs);*/
			}
		}
	}

}
