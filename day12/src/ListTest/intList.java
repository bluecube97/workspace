package ListTest;

public class intList {

	int[] numbers;
	int cntIdx;

	// 정수형 배열 생성
	public intList() {
		this.numbers = new int[5];
		this.cntIdx = 0;
	}

	// numbers 배열에 값 입력
	public void add(int number) {
		this.numbers[cntIdx] = number;
		this.cntIdx++;
	}

	// numbers 배열 전체에 0 입력
	public void clear() {
		this.cntIdx = 0;
	}
	
	// numbers 배열 길이
	public int size() {
		return this.cntIdx;
	}
	
	// numbers 배열 내 값 조회
	public int get(int index) {
		return numbers[index];
	}

}
