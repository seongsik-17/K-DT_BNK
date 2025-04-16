package abstract_parctice;

public class A extends AbstractParent {
	
	public A() {
		super(10);
		System.out.println("자식 클래스 기본 생성자");
	}

	@Override
	public void af() {
		System.out.println("오버라이드된 af()함수");
		
	}

}
