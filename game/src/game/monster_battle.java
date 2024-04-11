package game;

import java.util.Random;
import java.util.Scanner;

import javax.swing.text.html.CSS;

public class monster_battle {
	Scanner sc = new Scanner(System.in);
	Random rdm = new Random();

	public void battle_intro(char_stat ct, game_stat gs, monster_stat ms) {
		System.out.printf(
				ct.getP_name() + " 님은 모험의 여행을 떠났습니다. \n" + " 1 을 선택하시면, 계속 앞으로 나아갑니다." + " 2 를 선택하시면, 휴식을 취합니다.");
		gs.setTour_flag(sc.nextInt());
	}

	public void battle_phase(char_stat ct, game_stat gs, monster_stat ms, char_setting cs) {
		switch (gs.getTour_flag()) {
		case 1:
			System.out.println("----------------------------------------------------------");
			System.out.println(ct.getP_name() + " 님 기척이 느껴집니다. (주사위를 굴립니다.)");
			ms.setMonster_encounter(rdm.nextInt(gs.getDice_encounter()) + 1); // 주사위를 굴려 몬스터 조우 확률을 정함
			System.out.println(ms.getMonster_encounter() + "  나왔습니다.");
			if (ms.getMonster_encounter() > 4) {
				System.out.println("-----------------------------------------------------");
				System.out.println("아무 것도 없습니다. 계속 여행을 떠납니다.");
			} else if (ms.getMonster_encounter() <= 4) {
				System.out.println("-----------------------------------------------------");
				System.out.printf("몬스터가 있는 것 같습니다. \n" + "주사위를 굴립니다. \n");

				ms.setMonster_kind(rdm.nextInt(gs.getDice_kind()) + 1); // 주사위를 굴려 몬스터 종류를 정

				/* 몬스터 종류 설정 */
				switch (ms.getMonster_kind()) {
				case 1:
					ms.setMonster_name("Kobold"); // 몬스터 이름
					ms.setMonster_HP(100); // 몬스터 체력
					ms.setM_weapon_name("Dangger"); // 몬스터 무기명
					ms.setM_weapon_dice(30); // 몬스터 공격력 주사위
					ms.setMonster_str(10); // 몬스터 힘
					ms.setMonster_dex(8); // 몬스터 민첩성
					ms.setMonster_int(2); // 몬스터 지력
					ms.setMonster_level(1); // 몬스터 레벨
					ms.setMonster_exp(5); // 몬스터 처치시 획득 경험치
					break;

				case 2:
					ms.setMonster_name("Ork"); // 몬스터 이름
					ms.setMonster_HP(150); // 몬스터 체력
					ms.setM_weapon_name("Stick"); // 몬스터 무기명
					ms.setM_weapon_dice(40); // 몬스터 공격력 주사위
					ms.setMonster_str(14); // 몬스터 힘
					ms.setMonster_dex(7); // 몬스터 민첩성
					ms.setMonster_int(3); // 몬스터 지력
					ms.setMonster_level(2); // 몬스터 레벨
					ms.setMonster_exp(10); // 몬스터 처치시 획득 경험치
					break;

				case 3:
					ms.setMonster_name("Ork leader"); // 몬스터 이름
					ms.setMonster_HP(200); // 몬스터 체력
					ms.setM_weapon_name("Mace"); // 몬스터 무기명
					ms.setM_weapon_dice(50); // 몬스터 공격력 주사위
					ms.setMonster_str(15); // 몬스터 힘
					ms.setMonster_dex(9); // 몬스터 민첩성
					ms.setMonster_int(3); // 몬스터 지력
					ms.setMonster_level(3); // 몬스터 레벨
					ms.setMonster_exp(15); // 몬스터 처치시 획득 경험치
					break;

				case 4:
					ms.setMonster_name("Ogre"); // 몬스터 이름
					ms.setMonster_HP(300); // 몬스터 체력
					ms.setM_weapon_name("Stick"); // 몬스터 무기명
					ms.setM_weapon_dice(60); // 몬스터 공격력 주사위
					ms.setMonster_str(18); // 몬스터 힘
					ms.setMonster_dex(10); // 몬스터 민첩성
					ms.setMonster_int(3); // 몬스터 지력
					ms.setMonster_level(4); // 몬스터 레벨
					ms.setMonster_exp(20); // 몬스터 처치시 획득 경험치
					break;

				case 5:
					ms.setMonster_name("Fallen Knight"); // 몬스터 이름
					ms.setMonster_HP(200); // 몬스터 체력
					ms.setM_weapon_name("Bastard Sword"); // 몬스터 무기명
					ms.setM_weapon_dice(70); // 몬스터 공격력 주사위
					ms.setMonster_str(18); // 몬스터 힘
					ms.setMonster_dex(12); // 몬스터 민첩성
					ms.setMonster_int(4); // 몬스터 지력
					ms.setMonster_level(5); // 몬스터 레벨
					ms.setMonster_exp(30); // 몬스터 처치시 획득 경험치
					break;

				}

				System.out.println("-----------------------------------------------------");
				System.out.println(ms.getM_weapon_name() + " 으로 무장한  " + ms.getMonster_name() + "입니다.");
				System.out.println("체력	: " + ms.getMonster_HP());
				System.out.println("공격력	: " + ms.getM_weapon_dice());
				System.out.println("힘	: " + ms.getMonster_str());
				System.out.println("민첩	: " + ms.getMonster_dex());
				System.out.println("지력	: " + ms.getMonster_int());
				System.out.println("레벨	: " + ms.getMonster_level());
			}
			System.out.println("전투를 진행하시겠습니까?");
			System.out.println("1. 전투 진행	2. 전투 회피");
			gs.setBattle_flag(sc.nextInt());
			switch (gs.getBattle_flag()) {
			case 1:
				// 전투 진행
				System.out.println("전투를 진행합니다.");
				System.out.println("공격력이 상대보다 높으면 승리합니다.");
				System.out.println("공격력이 상대보다 낮거나 같으면");
				System.out.println("공격력의 차이만큼 데미지를 입습니다.");
				ms.setMonster_attk(ms.getM_weapon_dice() + rdm.nextInt(10) - 5);
				if (ct.getP_attk() > ms.getMonster_attk()) {
					System.out.println("승리하였습니다.");
					System.out.println(ms.getMonster_exp() + "만큼 경험치를 획득하셨습니다.");
				} else if (ct.getP_attk() <= ms.getMonster_attk()) {
					System.out.println("패배하였습니다.");
					System.out.println("체력이 " + (ct.getP_attk() - ms.getMonster_attk()) + "만큼 감소합니다.");
					ct.setP_hp(ct.getP_attk() - ms.getMonster_attk());
				}
				break;
			case 2:
				// 전투 회피
				System.out.println("전투를 회피합니다.");
				break;
			}
			break;
		case 2:
			System.out.printf(
					"--------------------------------------------- \n" + "잠을 잡니다.  zzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
			break;
		}

	}

	public void battle_end(char_stat ct, game_stat gs, monster_stat ms, char_setting cs) {

	}
}
