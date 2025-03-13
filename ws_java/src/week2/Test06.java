package week2;

public class Test06 {

	public static void main(String[] args) {
		
		int arr[] = new int[]{21,2,9,15,42,35,19,1,12,27};
		int a = 0;
		int a1 = 100;
		int point = 0;
		for(int i = 0; i < 10; i++) {
			
			if(arr[i] < 7) {
				a = 7-arr[i];
			}
			else {
				a = arr[i] - 7;
			}
			if(a < a1) {
				a1 = a;
				point = i;
			}
	
		}
		System.out.println("가장 가까운 수:"+arr[point]);
		System.out.println("수의 주소: arr["+point+"]");
		 
				
			
			
		}
	

	}


