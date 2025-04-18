package c07;

public class ProblemOfThread {
	public static int money = 0;

	public static void main(String[] args) throws InterruptedException {
		Runnable task1 = () -> {
			for (int i = 0; i < 10000; i++) {
				deposit();
				
			}
		};
		
		Runnable task2 = () -> {
			for(int i = 0; i < 10000; i++) {
				withdraw();
				
			}
		};
		
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		//공통된 자원으로 프로세스 처리를 위해 프로세서들을 줄 세우는것을 동기화라고 한다.
		
		
		System.out.println(money);
	}

	public synchronized static void withdraw() {
		money++;
		
	}

	public synchronized static void deposit() {
		money--;
		
	}

}
