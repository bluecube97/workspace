package game;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class roll_dice {
	Scanner sc = new Scanner(System.in);
	Random rdm = new Random();

	public void info_dice(char_stat ct) {
		System.out.println("-------------------------------------------------------");
		System.out.printf(
				"* " + ct.getWeapon_name() + " * 을/를 선택하셨습니다. 공격 시 " + ct.getWeapon_dice() + " 면체 주사위를 굴립니다. \n ");
		System.out.println("-------------------------------------------------------");
		System.out.println("마지막으로 " + ct.getP_name() + " 님의 능력치를 정하겠습니다.");
		System.out.println("10면체 주사위 두개를 굴립니다. 두개의 합에 따라 능력이 정해집니다.");
		System.out.println("-------------------------------------------------------");
	}

	public void set_dice(char_stat ct, char_setting cs) {
		int dice1 = rdm.nextInt(10);
		int dice2 = rdm.nextInt(10);
		int dice_sum = dice1 + dice2;

		System.out.println("첫 번째 주사위는 " + dice1);
		System.out.println("두 번째 주사위는 " + dice2);

		if (dice_sum >= 8 && dice_sum < 15) {
			ct.setP_hp(ct.getP_hp() - (ct.getP_hp() * 10) / 100);
			ct.setP_str(ct.getP_str() - (ct.getP_str() * 10) / 100);
			ct.setP_dex(ct.getP_dex() - (ct.getP_dex() * 10) / 100);
			ct.setP_int(ct.getP_int() - (ct.getP_int() * 10) / 100);
		} else if (dice_sum < 8) {
			ct.setP_hp(ct.getP_hp() - (ct.getP_hp() * 20) / 100);
			ct.setP_str(ct.getP_str() - (ct.getP_str() * 20) / 100);
			ct.setP_dex(ct.getP_dex() - (ct.getP_dex() * 20) / 100);
			ct.setP_int(ct.getP_int() - (ct.getP_int() * 20) / 100);
		}

		cs.p_attk_calc(ct);
	}

	public void info_stat(char_stat ct, game_stat gs) {
		System.out.println("-------------------------------------------------------");
		System.out.println(ct.getP_name() + " 님 당신의 능력치 입니다.");
		System.out.println("체력	: " + ct.getP_hp());
		System.out.println("힘	: " + ct.getP_str());
		System.out.println("민첩	: " + ct.getP_dex());
		System.out.println("지력	: " + ct.getP_int());
		System.out.println("공격력	: " + ct.getP_attk());
		System.out.println("무기	: " + ct.getWeapon_name());
		System.out.println("레벨	: " + ct.getP_lv());
		System.out.println("-------------------------------------------------------");
		System.out.println(ct.getP_name() + " 님 이대로 진행하시겠습니까? (1. YES   2. NO)");
		System.out.println("-------------------------------------------------------");
	}

	public void create_char_loof_end(char_stat ct, game_stat gs, List<char_stat> csl) {
		gs.setCharacter_set_flag(sc.nextInt());
		switch (gs.getCharacter_set_flag()) {
		case 1:
			System.out.println("캐릭터를 더 생성하시겠습니까? (1. YES	2. NO");
			gs.setCharacter_more_set_flag(sc.nextInt());
			switch (gs.getCharacter_more_set_flag()) {
			case 1:
				gs.setCharacter_set(true);
				// 구현해야댐 캐릭터 객체배열에 현재 만들어진 캐릭터 정보 넘기기
				csl.add(ct);
				break;
			case 2:
				gs.setCharacter_set(false);
				csl.add(ct);
				break;
			}
		case 2:
			gs.setCharacter_set(true);
			System.out.println("---------------------------------------------");
			break;
		}
	}
}
