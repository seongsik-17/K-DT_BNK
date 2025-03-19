package week3;

import java.util.Arrays;
import java.util.Random;

public class Selection_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rd = new Random();
		int rdNum = 0;
		int temp;
		int arr[] = new int[] {9,3,2,6,8,1,4,5,7};
		
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp; 
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		

	}

}
