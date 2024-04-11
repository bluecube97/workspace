package game2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class var_game_hashlist {
	List<HashMap<String, Object>> extCharList = new ArrayList<HashMap<String, Object>>();
	List<HashMap<String, Object>> extMobList = new ArrayList<HashMap<String, Object>>();
	List<HashMap<String, Object>> extJobList = new ArrayList<HashMap<String, Object>>();
	List<HashMap<String, Object>> extCharWeaponList = new ArrayList<HashMap<String, Object>>();
	HashMap<String, Object> insertCharMap = new HashMap<>();
	HashMap<String, Object> insertMobMap = new HashMap<>();
	HashMap<String, Object> insertJobMap = new HashMap<>();
	HashMap<String, Object> insertCharWeaponMap = new HashMap<>();

	public var_game_hashlist() {

	}

	public var_game_hashlist(List<HashMap<String, Object>> extCharList, List<HashMap<String, Object>> extMobList,
			List<HashMap<String, Object>> extJobList, List<HashMap<String, Object>> extCharWeaponList,
			HashMap<String, Object> insertCharMap, HashMap<String, Object> insertMobMap,
			HashMap<String, Object> insertJobMap, HashMap<String, Object> insertCharWeaponMap) {
		this.extCharList = extCharList;
		this.extMobList = extMobList;
		this.extJobList = extJobList;
		this.extCharWeaponList = extCharWeaponList;
		this.insertCharMap = insertCharMap;
		this.insertMobMap = insertMobMap;
		this.insertJobMap = insertJobMap;
		this.insertCharWeaponMap = insertCharWeaponMap;
	}

	public List<HashMap<String, Object>> getExtCharList() {
		return extCharList;
	}

	public void setExtCharList(List<HashMap<String, Object>> extCharList) {
		this.extCharList = extCharList;
	}

	public List<HashMap<String, Object>> getExtMobList() {
		return extMobList;
	}

	public void setExtMobList(List<HashMap<String, Object>> extMobList) {
		this.extMobList = extMobList;
	}

	public List<HashMap<String, Object>> getExtJobList() {
		return extJobList;
	}

	public void setExtJobList(List<HashMap<String, Object>> extJobList) {
		this.extJobList = extJobList;
	}

	public List<HashMap<String, Object>> getExtCharWeaponList() {
		return extCharWeaponList;
	}

	public void setExtCharWeaponList(List<HashMap<String, Object>> extCharWeaponList) {
		this.extCharWeaponList = extCharWeaponList;
	}

	public HashMap<String, Object> getInsertCharMap() {
		return insertCharMap;
	}

	public void setInsertCharMap(HashMap<String, Object> insertCharMap) {
		this.insertCharMap = insertCharMap;
	}

	public HashMap<String, Object> getInsertMobMap() {
		return insertMobMap;
	}

	public void setInsertMobMap(HashMap<String, Object> insertMobMap) {
		this.insertMobMap = insertMobMap;
	}

	public HashMap<String, Object> getInsertJobMap() {
		return insertJobMap;
	}

	public void setInsertJobMap(HashMap<String, Object> insertJobMap) {
		this.insertJobMap = insertJobMap;
	}

	public HashMap<String, Object> getInsertCharWeaponMap() {
		return insertCharWeaponMap;
	}

	public void setInsertCharWeaponMap(HashMap<String, Object> insertCharWeaponMap) {
		this.insertCharWeaponMap = insertCharWeaponMap;
	}

}
