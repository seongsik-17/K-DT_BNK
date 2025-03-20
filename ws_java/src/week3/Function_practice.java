package week3;

public class Function_practice {
	static int f(int a, int b, int c) {
		int arr[] = new int[3];
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		int sum = 1;
		for(int i = 0; i < arr.length; i++) {
			sum +=arr[i];
		}
		
		
		return sum;
	}

	public static void main(String[] args) {
		
		
		int n = 5;
		int m = 10;
		int k = 20;
		System.out.println(f(n,m,k));

	}

}
