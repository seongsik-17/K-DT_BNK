package c04;

public class Calc implements Calc_if {
	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int minus(int a, int b) {
		return a - b;
	}

	@Override
	public int multi(int a, int b) {
		return a * b;
	}

	@Override
	public double division(int a, int b) {

		return (double) a / (double) b;
	}
	

//
//Vo에서는 필수적으로 해야하는 작업  = getter setter
//Vo가 아니면 있어도 그만 없어도 그만(변수가 존재해도)
//DTO는 전달하는 용도이기 때문에 값이 변하면 안된다.
//DTO는 상수로 항상 존재해야함  = final(상수) = 클래스에 붙으면 상속 불가	
}
