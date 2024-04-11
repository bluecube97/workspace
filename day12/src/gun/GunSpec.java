package gun;

public class GunSpec {

	int accuracy; // 명중률
	int damage; // 데미지
	int magazine; // 장탄수
	int fireRate; // 연사속도(분당 발사수)

	public GunSpec() {

	}

	
	
	public GunSpec(int accuracy, int damage, int magazine, int fireRate) {
		this.accuracy = accuracy;
		this.damage = damage;
		this.magazine = magazine;
		this.fireRate = fireRate;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMagazine() {
		return magazine;
	}

	public void setMagazine(int magazine) {
		this.magazine = magazine;
	}

	public int getFireRate() {
		return fireRate;
	}

	public void setFireRate(int fireRate) {
		this.fireRate = fireRate;
	}

}
