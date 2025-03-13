package week1;

import java.util.Arrays;
import java.util.Random;

public class Test04 {

	public static void main(String[] args) {
		int arr[] = new int[5];
		int rdNum = 0;
		int[] a = new int[5];
		int[] b = new int[5];
		int j = 0;
		int j1 = 0;
		
		Random rd = new Random();
		
		for(int i = 0; i < 5; i++) {
			 rdNum = rd.nextInt(10) + 1;
			 arr[i] = rdNum;
		}
		
		for(int i = 0; i < 5; i++) {
			if(arr[i]%2!=0){
				a[j] = arr[i];				
				//System.out.println(a[j]);
				j++;
			}
			else {
				b[j1] = arr[i];				
				//System.out.println(b[j1]);
				j1++;
			}
		
			
		}
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
		

	}

}
