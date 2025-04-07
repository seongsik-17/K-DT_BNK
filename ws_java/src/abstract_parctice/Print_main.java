package abstract_parctice;

import java.util.Scanner;

public class Print_main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Document o = new Document();
		Select s = new Select();


		o.setA(o.write());// 문자열을 입력받는 함수
		s.select(o);//컬러를 설정하는 함수

	}

}
//인터페이스 **able 이라고 이름짓는 이유가 기능을 표시하기 위해 사용
//Java에서 클래스의 상속은 단 하나의 클래스에서만 가능하다(다중 상속 불가능!!)
//하지만 하나의 클래스에서 상속을 받고 나머지는 interface를 통해 구현체로 생성
//해서 다중상속을 구현 가능하게 한다.