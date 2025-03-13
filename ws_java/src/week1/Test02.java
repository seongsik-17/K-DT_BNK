package week1;

public class Test02 {

	public static void main(String[] args) {
		//1부터 10까지 더하는 반복문
		int sum = 0;
		for(int i=0; i <= 10; i++) {
			sum = sum + i;
			//System.out.print(sum);
			//System.out.println(" "+i);
		}
		System.out.println(sum);
		
		//0~99까지 홀수만 더하기
		int odd_sum = 0;
		
		for(int n=1; n<=99; n++) {
			if(n%2!=0) odd_sum = odd_sum+n; 
		}
		System.out.println(odd_sum);
		
		//1/2+2/3+···49/50	합 구하기
		float n1 = 1;
		float m = 2;
		float smsum = 0;
		
		for(int j = 0; j < 49; j++) {
			smsum = smsum+((n1+j)/(m+j));
			
					
		}
		System.out.printf("%.3f\n",smsum);
		
		//반복문으로 배열 만들기
		int[] arr = new int[10];
		for(int k = 0; k < 10; k++) {
			arr[k] = k+1;
			System.out.print(arr[k]+" ");
		}
		System.out.println("\n----------------------");
		arr[4] = 100;
		
		int[] brr = new int[10];
		for(int i = 0; i < 10; i++) {
			brr[i] = 0;
			System.out.print(brr[i]+" ");
			
		}
		System.out.println("\n----------------------");
		for(int l = 0; l < 10; l++) {
			brr[l] = arr[9 - l];
			System.out.print(brr[l]+" ");
			}
		System.out.println("\n----------------------");
		}
		
		
		

	}

	


