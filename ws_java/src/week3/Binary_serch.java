package week3;

import java.util.Arrays;

public class Binary_serch {

	public static void main(String[] args) {
		int arr[] = new int[] {1,2,4,6,7,9,8,3,5};
		int n = (int)Math.floor(10.9);
		int temp = 0;
		
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp; 
				}
			}
			
		}System.out.println(Arrays.toString(arr));
		
		int start = (int)Math.floor((arr.length/2));
		int find_num = 6;
		
		while(true) {
			if(arr[start] < find_num) {//중간 값이 찾는 수보다 작을 경우 배열 오른쪽으로 가서 또 중간값을 찾기
				start = (arr.length+start)/2;
				if(arr[start] == find_num) {//새로운 중간 값과 찾는 수가 일치하면 종료
					System.out.println("수를 찾았습니다!"+arr[start]);
					break;
				}
				else {
					continue;
				}			
				
				
			}
			
		}
		
		
		
		
		

	}

}
