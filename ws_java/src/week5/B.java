package week5;

public class B extends A {
	int k;
	B(){
		super(10);//부모클래스에 잡아넣가
		System.out.println("B클래스 기본 생성자");
	}
	@Override
	void fa(){
		System.out.println("B클래스의 fa함수...");
	}
	void fb() {
		System.out.println("fb함수 실행...");
	}

}
