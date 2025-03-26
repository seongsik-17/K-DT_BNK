package class_test3;

import vo.A;

public class Class_test3_main {

	public static void main(String[] args) {
		A a1 = new A();
		a1.setn(10);
		System.out.println(a1.getn());
		a1.setS("집에가고 싶다");
		System.out.println(a1.showInfo());
		System.out.println(a1.toString());

	}

}
