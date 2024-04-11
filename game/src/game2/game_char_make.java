package game2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class game_char_make {
	Scanner sc = new Scanner(System.in);

	public void input_name(var_game_hashlist vgh) {
		System.out.println("당신의 이름을 입력하세요.");
		String pNm = sc.next();
		vgh.getInsertCharMap().put("pNm", pNm);
	}

	public void select_job(var_game_hashlist vgh) {
		while (true) {
			String pNm = vgh.getInsertCharMap().get("pNm").toString();
			System.out.println("---------------------------------------------");
			System.out.println(pNm + " 님 직업을 선택해주세요."); // insertCharMap에 저장된
														// pNm 값 호출
			System.out.println("1. 전사	2. 마법사	3. 궁수	4. 도적	5. 해적");
			String pJob = sc.next();
			vgh.getInsertCharMap().put("pJob", pJob);

			if (!(pJob.equals("1") || pJob.equals("2") || pJob.equals("3") || pJob.equals("4") || pJob.equals("5"))) {
				System.out.println("잘못 입력하셨습니다.");
			} else
				break;
		}
	}

	public void set_job(var_game_hashlist vgh) {
		for (int i = 0; i < vgh.getExtJobList().size(); i++) {
			int pJob = Integer.valueOf((String) vgh.getInsertCharMap().get("pJob"));
			int seq = Integer.valueOf((String) vgh.getExtJobList().get(i).get("seq"));
			if (pJob == seq) {
				Object hp = vgh.getExtJobList().get(i).get("hp");
				Object str = vgh.getExtJobList().get(i).get("str");
				Object dex = vgh.getExtJobList().get(i).get("dex");
				Object int_ = vgh.getExtJobList().get(i).get("int");
				Object luk = vgh.getExtJobList().get(i).get("luk");
				Object jobNm = vgh.getExtJobList().get(i).get("jobNm");
				vgh.getInsertCharMap().put("pHp", hp);
				vgh.getInsertCharMap().put("pStr", str);
				vgh.getInsertCharMap().put("pDex", dex);
				vgh.getInsertCharMap().put("pInt", int_);
				vgh.getInsertCharMap().put("pLuk", luk);
				vgh.getInsertCharMap().put("pJob", jobNm);

				break;
			}
		}

	}

	public void set_weapon(var_game_hashlist vgh) {
		List<HashMap<String, Object>> weapon = new ArrayList<HashMap<String, Object>>();
		weapon = vgh.getExtCharWeaponList();
		String pJob = vgh.getInsertCharMap().get("pJob").toString();
		String reqJob;
		int cnt = 1;
		String[] weaponNm_save;
		weaponNm_save = new String[2];
		
		System.out.println(pJob + "은(는) 다음 무기를 선택할 수 있습니다.");
		
		for (int i = 0; i < weapon.size(); i++) {
			reqJob = weapon.get(i).get("reqJob").toString();
			if (reqJob.equals(pJob)) {
				String weaponNm = vgh.getExtCharWeaponList().get(i).get("weaponNm").toString();
				System.out.print(cnt + ". " + weaponNm + "	");
				cnt++;
			}
		}
		System.out.println();
	}

	public void info_dice(var_game_hashlist vgh) {
		String weaponNm = vgh.getInsertCharMap().get("pWeapon").toString();
		String weaponDice = vgh.getInsertCharMap().get("pWeaponDice").toString();
		String pNm = vgh.getInsertCharMap().get("pNm").toString();

		System.out.println("-------------------------------------------------------");
		System.out.printf("* " + weaponNm + " * 을/를 선택하셨습니다. 공격 시 " + weaponDice + " 면체 주사위를 굴립니다. \n ");
		System.out.println("-------------------------------------------------------");
		System.out.println("마지막으로 " + pNm + " 님의 능력치를 정하겠습니다.");
		System.out.println("10면체 주사위 두개를 굴립니다. 두개의 합에 따라 능력이 정해집니다.");
		System.out.println("-------------------------------------------------------");

	}

	public void set_dice(var_game_hashlist vgh) {

	}
}
