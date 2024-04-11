package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import lombok.Data;

@Data
public class ListMain {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("이서방");
		list.add("망냥냥");

		// 데이터 집합 읽어오기
		// list.forEach(함수식을 전달 or 함수형 객체); // 함수형 프로그래밍
		System.out.println("1. forEach(람다식 표현)");
		list.forEach((String x) -> System.out.println(x));

		System.out.println("2. for문");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("3. 향상된 for");
		for (String name : list) {
			System.out.println("당신의 이름은 " + name);
		}

		// Iterator
		System.out.println("4. Iterator를 활용한 출력");
		Iterator<String> it1 = list.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}

		System.out.println("5. Iterator 람다식");
		Iterator<String> it2 = list.iterator();
		it2.forEachRemaining((x) -> System.out.println(x));

		System.out.println("6. Iterator 메서드 참조형");
		Iterator<String> it3 = list.iterator();
		it3.forEachRemaining(System.out::println);

		System.out.println("7. Collection sort");
		System.out.println("before: " + list.toString());
		List<String> list1 = new ArrayList<String>();
		list1 = list;
		Collections.sort(list1); // 퀵정렬
		System.out.println("after: " + list1.toString());

		
		
	}

}
