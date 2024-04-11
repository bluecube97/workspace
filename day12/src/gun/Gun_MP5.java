package gun;

public class Gun_MP5 extends GunSpec {

	public Gun_MP5() {

	}

	public Gun_MP5(int accuracy, int damage, int magazine, int fireRate) {
		super(accuracy, damage, magazine, fireRate);

	}

	public void initGun_MP5() {
		setAccuracy(100);
		setDamage(10);
		setMagazine(30);
		setFireRate(1000);
	}

}
