package c07;

import lombok.Data;

@Data
public class MyThread extends Thread {
	//Thread를 상속 받는다
	
	@Override
	public void run() {//현재 실행중인 메서드를 출력하는 메서드
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
			try {
				Thread.sleep(1000);
				
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
