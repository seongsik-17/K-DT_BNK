package week4;

public class A {
		int n;
		String s;
		
		void f(){
			System.out.println(f2() + ","+ s);//같은 클래스 안에서는 참조변수를 사용하지 않는
		}
		int f2() {
			return n;
		}
		


}
