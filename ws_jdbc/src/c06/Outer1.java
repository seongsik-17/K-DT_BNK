package c06;

public class Outer1 {
	private int speed = 10;
	
	public void getMarine() {
		
	}
	
	class MemberInner1//외부 클래스에서는 아예 필요가 없다  오직 Outer1클래스에서만 필요로함 ->내부 클래스(멤버처럼 다룸) 
    //의미있는 단위로 묶어서 처리하고자 클래스로 묶음
	{
		public void move() {
			System.out.printf("인간형 유닛이 %d 속도로 이동합니다.\n",speed);
			
		}
	}
	
	public void getUnit() {
		MemberInner1 inner = new MemberInner1();
		inner.move();
	}
}
