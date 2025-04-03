package absttact;

public abstract class AbstractParent {
	public int n;
	
	//AbstractParent(){
	//	System.out.println("AbstractParent 생성자 호출");
	//}
	
	AbstractParent(int n){
		this.n = n;
	}
	public abstract void af();
	
	void f() {
		System.out.println("f()함수 실행...");
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getN() {
		return n;
	}

}
