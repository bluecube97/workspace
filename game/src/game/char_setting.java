package game;

import java.util.Scanner;

public class char_setting {
	Scanner sc = new Scanner(System.in);

	public void set_job(char_stat ct) {
		switch (ct.getP_job()) {
		case 1: // 전사 선택
			ct.setP_hp(200);
			ct.setP_str(20);
			ct.setP_dex(10);
			ct.setP_int(5);
			System.out.println("전사는 다음 무기를 선택할 수 있습니다.");
			System.out.println("1. Sword  2. Bastard Sword");
			ct.setP_weapon(sc.nextInt());
			if (ct.getP_weapon() == 1) {
				ct.setWeapon_name("Sword");
				ct.setWeapon_dice(8);
			} else if (ct.getP_weapon() == 2) {
				ct.setWeapon_name("Bastard Sword");
				ct.setWeapon_dice(10);
				ct.setP_dex(ct.getP_dex() - 2); // 무게로 인한 민첩성 저하
			}
			break;

		case 2: // 마법사 선택
			ct.setP_hp(100);
			ct.setP_str(8);
			ct.setP_dex(9);
			ct.setP_int(20);
			System.out.println("마법사는 다음 무기를 선택할 수 있습니다.");
			System.out.println("1. Staff    2. Magic Mace");
			ct.setP_weapon(sc.nextInt());
			if (ct.getP_weapon() == 1) {
				ct.setWeapon_name("Staff");
				ct.setWeapon_dice(4);
			} else if (ct.getP_weapon() == 2) {
				ct.setWeapon_name("Magic Mace");
				ct.setWeapon_dice(6);
				ct.setP_dex(ct.getP_dex() - 1); // 무게로 인한 민첩성 저하
			}
			break;

		case 3: // 사냥꾼 선택
			ct.setP_hp(150);
			ct.setP_str(14);
			ct.setP_dex(20);
			ct.setP_int(10);
			System.out.println("사냥꾼은 다음 무기를 선택할 수 있습니다.");
			System.out.println("1. Long Bow    2. Bolt");
			ct.setP_weapon(sc.nextInt());
			if (ct.getP_weapon() == 1) {
				ct.setWeapon_name("Long Bow");
				ct.setWeapon_dice(6);
			} else if (ct.getP_weapon() == 2) {
				ct.setWeapon_name("Bolt");
				ct.setWeapon_dice(8);
				ct.setP_dex(ct.getP_dex() - 2); // 무게로 인한 민첩성 저하
			}
			break;
		}
	}
	
	public void p_attk_calc(char_stat ct) {
		switch (ct.getP_job()) {
		case 1: // 전사
			ct.setP_attk(ct.getP_str() * 2 + ct.getP_dex());
			break;
		case 2: // 마법사
			ct.setP_attk(ct.getP_dex() + ct.getP_int() * 2);
			break;
		case 3: // 사냥꾼
			ct.setP_attk(ct.getP_str() + ct.getP_dex() * 2);
			break;
		}
	}
}
