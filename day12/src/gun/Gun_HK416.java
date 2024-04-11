package gun;

public class Gun_HK416 extends GunSpec {

	public Gun_HK416() {

	}

	public Gun_HK416(int accuracy, int damage, int magazine, int fireRate) {
		super(accuracy, damage, magazine, fireRate);

	}

	public void initGun_HK416() {
		setAccuracy(100);
		setDamage(10);
		setMagazine(30);
		setFireRate(1000);
	}
}
