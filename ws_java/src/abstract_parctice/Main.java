package abstract_parctice;

public class Main {

	public static void main(String[] args) {
		//AbstractParent ap = new AbstractParent();
		A a = new A();//자신의 생성자를 만들지는 못하지만 자식 클래스가
		
		//생성하는 경우에는 도와준다.
		//a.n = 10;
		System.out.println(a.n);
		//a.setN(20);
		System.out.println(a.getN());		
		
		

	}

}
