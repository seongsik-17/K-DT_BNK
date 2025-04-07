package abstract_parctice;

public class C  implements IB {

	@Override
	public void f1() {
		System.out.println("C클래스의 f1함수...");
		
	}

	@Override
	public int f2() {
		System.out.println("C클래스의 f2함수...");
		return 0;
	}
//C클래스를 만들고
	//C클래스도 IB를 사용
	//메인에서 반복문으로 실행시켜라
	
}
