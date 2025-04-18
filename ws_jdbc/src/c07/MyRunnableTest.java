package c07;

public class MyRunnableTest {

	public static void main(String[] args) {
		MyRunnable mr = new MyRunnable();
		
		Thread t1 = new Thread(mr,"Thread - A");
		Thread t2 = new Thread(mr,"Thread - A");
		
		t1.start();
		t2.start();
		

	}

}
