package week1;
import java.util.Arrays;
public class Test03 {

	public static void main(String[] args) {
		int j = 0;//홀수 배열 출력용
		int j1 = 0;//짝수 배열 출력용
		//arr[10] 배열 생성
		int[] arr = new int [] {1,2,3,4,5,6,7,8,9,10};
		
		
		int[] a = new int[5];//홀수를 저장할 배열 a 생성(0~9)
		int[] b = new int[5];//짝수를 저장할 배열 b 생성(0~9)
		//arr배열 요소의 홀/짝 판별 후 저장
		for(int i = 0; i < 10; i++) {
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
		
		System.out.println("a[] ="+Arrays.toString(a));
		System.out.println("b[] ="+Arrays.toString(b));
	

		

	}

}
