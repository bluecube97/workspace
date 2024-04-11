package ListTest;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		// List<Integer> list = new ArrayList<Integer>();
		intList list = new intList();
		
		list.add(7);
		list.add(12);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		list.clear();
		
		System.out.println(list.size());
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
