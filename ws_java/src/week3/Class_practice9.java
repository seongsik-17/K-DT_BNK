package week3;

public class Class_practice9 {
	
	static void f(int x, int y) {
		int temp = x;
		x = y;
		y = temp;
		
	}
	static int[] f1(int []arr) {
		int temp = arr[1];
		arr[1] = arr[0];
		arr[0] = temp;
		
		return arr;
		
	}
	

	public static void main(String[] args) {
		int n1 = 5;
		int n2 = 3;
		int arr[] = new int[2];
		arr[0] = n1;
		arr[1] = n2;
		System.out.printf("f1함수 실행 전:%d, %d\n",n1,n2);
		f1(arr);
		System.out.printf("f1함수 실행 후:%d, %d\n",arr[0],arr[1]);

	}

}
