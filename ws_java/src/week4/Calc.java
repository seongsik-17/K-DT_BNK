package week4;

public class Calc {
	//변수가 2개
	//사칙연산을 진행함(멤버변수로)
	
	
	void add(int num1, int num2) {
		System.out.println(num1+" + "+num2 +" = "+ (num1+num2));
	}
	void minus(int num1, int num2) {
		System.out.println(num1+" - "+num2 +" = "+ (num1-num2));
	}
	void multi(int num1, int num2) {
		System.out.println(num1+" * "+num2 +" = "+ (num1*num2));
	}
	void divi(double num1, double num2) {
		System.out.println(num1+" / "+num2 +" = "+ (num1/num2));
	}

}
