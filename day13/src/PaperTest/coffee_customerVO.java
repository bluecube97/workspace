package PaperTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class coffee_customerVO {
	List<String> menu = new ArrayList<String>();
	List<Integer> price = new ArrayList<Integer>();
	List<HashMap<String, Object>> orderList = new ArrayList<HashMap<String, Object>>();

	public coffee_customerVO() {

	}

	public coffee_customerVO(List<String> menu, List<Integer> price, List<HashMap<String, Object>> orderList) {
		this.menu = menu;
		this.price = price;
		this.orderList = orderList;

	}

	public List<String> getMenu() {
		return menu;
	}

	public void setMenu(List<String> menu) {
		this.menu = menu;
	}

	public List<Integer> getPrice() {
		return price;
	}

	public void setPrice(List<Integer> price) {
		this.price = price;
	}

	public List<HashMap<String, Object>> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<HashMap<String, Object>> orderList) {
		this.orderList = orderList;
	}

}
