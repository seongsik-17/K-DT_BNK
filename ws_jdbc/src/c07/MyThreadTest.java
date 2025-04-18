package c07;

public class MyThreadTest {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		
		
		t1.setName("Thread-A");
		t2.setName("Thread-B");
		t1.start();
		t2.start();
		
		
		System.out.println("----End of Thread-----");
		//run메서드를 직접 호출하면 작동을 안하니까
		//start를 사용하면 run메서드를 호출한다.

	}

}
