package gun;

public class GunInit {

	public void InitGun(Gun_K2 k2, Gun_MP5 mp5, Gun_HK416 hk416, Gun_FiveSeven fs, Gun_AK47 ak47) {
		k2.initGun_K2();
		mp5.initGun_MP5();
		hk416.initGun_HK416();
		fs.initGun_FiveSeven();
		ak47.initGun_AK47();
	}

}
