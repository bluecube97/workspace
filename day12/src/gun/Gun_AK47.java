package gun;

public class Gun_AK47 extends GunSpec {

	public Gun_AK47() {

	}

	public Gun_AK47(int accuracy, int damage, int magazine, int fireRate) {
		super(accuracy, damage, magazine, fireRate);

	}

	public void initGun_AK47() {
		setAccuracy(100);
		setDamage(10);
		setMagazine(30);
		setFireRate(1000);
	}
}