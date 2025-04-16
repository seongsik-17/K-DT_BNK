package c04;

public class Calc2 extends Calc implements Calc_if{

	
	public int absolute(int a) {//절대값 구하기
		if(a < 1) {
			return a * -1;
		}
		else {
			return a;
		}
		
	}


}
