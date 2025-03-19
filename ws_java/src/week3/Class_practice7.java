package week3;

public class Class_practice7 {
	public static int[] f(int n1, int n2) {
		int arr[] = new int[2];
		arr[0] = n1+n2;
		arr[1] = n1-n2;
		
		return arr;
		
		
	}
	
	
	
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = 20;
		
		
		int sum = f(n1, n2)[0];
		int minus = f(n1, n2)[1];
		
		System.out.println("두 수의 합은: "+sum);
		System.out.println("두 수의 차는: "+minus);
		
	}


}
