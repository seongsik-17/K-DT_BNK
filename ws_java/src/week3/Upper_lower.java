package week3;

import java.util.Arrays;

public class Upper_lower {
	static char[] upper(char[]A) {
		for(int i = 0; i < A.length; i++ ) {
			if(A[i]>96) {
				A[i] -=32; 
			}
		}
		return A;
	}
	
	static char[] lower(char[]A) {
		for(int i = 0; i < A.length; i++ ) {
			if(A[i]< 97) {
				A[i] +=32; 
			}
		}
		return A;
	}

	public static void main(String[] args) {
		
		char a[] = new char[] {'A','b','C','d','E'};
		
		System.out.print("대문자로 다 바꿔서 출력>> ");
		System.out.println(Arrays.toString(upper(a)));
		System.out.print("소문자로 다 바꿔서 출력>> ");
		System.out.println(Arrays.toString(lower(a))); 
		
		
		
		

	}

}
