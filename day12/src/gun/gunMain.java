package gun;

public class gunMain {

	public static void main(String[] args) {
//		총의 명중률, 발당 데미지, 연발/단발, 장탄수, 연사속도 등을 고려하여
//		타겟에 총을 쐈을 때 명중률, 더미가 입은 데미지를 출력하는 프로그램
//
//		조건 1. 총기류는 5개(바뀔수도 있음)의 스펙이 다 다름.
//		조건 2. 총기류는 총기 클래스를 상속받아 구현함. (총기 종류만큼 자식 클래스 생성)
//
//		입력 데이터
//		1. 총기 종류
//		2. 몇발 쏠것인지(총기의 장탄수보다 적고, 0보다 커야함)
//
//		출력 데이터
//		1. 더미에 맞은 총알 개수
//		2. 더미가 입은 데미지
//		3. 사격에 소요된 시간
		
		GunIO gio = new GunIO();
		GunInit gi = new GunInit();
		Dummy dm = new Dummy();
		
		Gun_K2 k2 = new Gun_K2();
		Gun_MP5 mp5 = new Gun_MP5();
		Gun_HK416 hk416 = new Gun_HK416();
		Gun_FiveSeven fs = new Gun_FiveSeven();
		Gun_AK47 ak47 = new Gun_AK47();
		
		gi.InitGun(k2, mp5, hk416, fs, ak47);
		
		gio.GunPrint(); // 총기의 종류를 출력
		gio.GunInput(); // 사용할 총기 입력
		gio.GunShotInput(); // 발사할 총탄 수 입력
		
		dm.DummyOutput(); // 더미가 맞은 총알 개수, 입은 데미지, 사격에 소요 된 시간 출력
		
		System.out.println(k2.getAccuracy());

	}

}
