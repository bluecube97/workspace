package Thread;

public class threadMain {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());

		for (int i = 1; i <= 10; i++) {
			System.out.printf("%2d", i);
		}
		System.out.println();
		for (int i = 11; i <= 20; i++) {
			System.out.printf("%3d", i);
		}

		System.out.println("--- Thread");
		// 1. Thread
		
	}

}
