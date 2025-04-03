package absttact;

public class B implements IB {
	//클래스B는 IB인터페이스의 추상메서드를 구현한 클래스입니다.(상속 아님)

	@Override
	public void f1() {
		System.out.println("B클래스의 f1함수...");
		
		
	}

	@Override
	public int f2() {
		System.out.println("B클래스의 f2함수...");
		
		return 0;
	}
	

}
