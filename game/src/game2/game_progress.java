package game2;

import java.util.Scanner;

public class game_progress {
	Scanner sc = new Scanner(System.in);
	sql_game_char sgc = new sql_game_char();
	sql_game_mob sgm = new sql_game_mob();
	sql_game_job sgj = new sql_game_job();
	sql_game_char_weapon scw = new sql_game_char_weapon();

	game_char_make cm = new game_char_make();

	public void gameProgress(var_game_hashlist vgh, game_stat gs) {

		while (gs.isStart_game()) {
			vgh.setExtCharList(sgc.extCharData());
			vgh.setExtMobList(sgm.extMobData());
			vgh.setExtJobList(sgj.extJobData());
			vgh.setExtCharWeaponList(scw.extCharWeaponData());
			menuSelect(vgh, gs);
		}
	}

	public void menuSelect(var_game_hashlist vgh, game_stat gs) {
		System.out.println("-----------------");
		System.out.println("1. 캐릭터 생성하기.");
		System.out.println("2. 스쿼드 편성하기.");
		System.out.println("3. 모험 떠나기.");
		System.out.println("4. 게임 종료.");
		System.out.println("-----------------");
		gs.setMenu_flag(sc.nextInt());

		switch (gs.getMenu_flag()) {
		case 1:
			cm.input_name(vgh);
			cm.select_job(vgh);
			cm.set_job(vgh);
			cm.set_weapon(vgh);
			cm.info_dice(vgh);
			cm.set_dice(vgh);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			gs.setStart_game(false);
			System.out.println("게임이 종료되었습니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}
}
