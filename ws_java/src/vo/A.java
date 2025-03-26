package vo;

public class A {
	private int n;
	private String s;
	
	public void setn(int a) {
		this.n = a;
	}
	public int getn() {
		return n;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getS() {
		return s;
	}
	public String showInfo() {
		return "n = "+n+", s = "+s;
	}
	@Override//@가 붙으면 어노테이션 내부적으로 코드가 있어서 자동으로 기능이 실행됨.
	public String toString() {//함수이름을 틀리지 않기 위해서 오버라이드를 사용한다.(이미 약속된)
		return "A [n=" + n + ", s=" + s + "]";
	}
	//오버라이드는 함수의 시그니쳐는 동일하고 기능의 차이는 존재
	//오버로드는 시그니쳐가 달라야한다.
	
	

}
