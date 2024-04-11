package gun;

public class Gun_K2 extends GunSpec {

	public Gun_K2() {

	}

	public Gun_K2(int accuracy, int damage, int magazine, int fireRate) {
		super(accuracy, damage, magazine, fireRate);

	}

	public void initGun_K2() {
		setAccuracy(100);
		setDamage(10);
		setMagazine(30);
		setFireRate(1000);
	}

}
