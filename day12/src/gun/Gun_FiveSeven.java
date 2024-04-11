package gun;

public class Gun_FiveSeven extends GunSpec {

	public Gun_FiveSeven() {

	}

	public Gun_FiveSeven(int accuracy, int damage, int magazine, int fireRate) {
		super(accuracy, damage, magazine, fireRate);

	}

	public void initGun_FiveSeven() {
		setAccuracy(100);
		setDamage(10);
		setMagazine(30);
		setFireRate(1000);
	}
}
