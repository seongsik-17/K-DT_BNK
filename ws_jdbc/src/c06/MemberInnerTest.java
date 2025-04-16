package c06;

public class MemberInnerTest {

	public static void main(String[] args) {
		Outer1 out = new Outer1();
		
		out.getUnit();
		
		Outer1.MemberInner1 inner = out.new MemberInner1();
		inner.move();

	}

}
