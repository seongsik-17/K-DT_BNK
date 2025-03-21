package week3;

public class Test01 {
	
	
	
	static int f(int param1) {
		int n = 10;
		int result = f2(param1, n);
		return result;
	}
	static int f2(int param1, int param2) {
		int n = 100;
		int result = f3( param1, param2, n);
		return result;
	}
	static int f3(int param1, int param2,int param3) {
		int n = 1000;
		int result = f4(param1,param2, param3, n);
		return result;
	}
	static int f4(int param1, int param2, int param3, int param4) {
		return param1 + param2 + param3 + param4;
	}
	
	

	public static void main(String[] args) {
		int n = 1;
		int result = f(n);
		System.out.println(result);

	}

}
