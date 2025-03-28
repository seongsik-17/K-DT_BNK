package class_test4;

import vo.AAA;

public class Preactice_Static_main {

	public static void main(String[] args) {
		
		
		
		
		AAA.x = 30;
		System.out.println(AAA.x);
		//인스턴스를 생성하지 않아도 사용 가능
		//클래스에 존재한다.
		
		AAA a1 = new AAA();
		AAA a2 = new AAA();
		
		a1.x = 100;//static 변수는 하나만 존재
		
		System.out.println(a1.x);
		System.out.println(a2.x);
		
		AAA.f();
		AAA.y = 70;
		//static함수에서 인스턴스 변수로 접근하는건 불가능
		//non-static 함수에서 static(클래스)변수로 접근하는건 가능하다.!!
	}
		
}
