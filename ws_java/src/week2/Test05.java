package week2;

public class Test05 {

	public static void main(String[] args) {
		int n = -1;
		
		String binaryString = Integer.toBinaryString(n);
		System.out.println(binaryString);
		
		int n2 = 0b0110;//2진수를 출력할 경우에는 접두어가 0b
		System.out.println(n2);
		
		int n3 = 0110;//8진수 접두어: 0
		System.out.println(n3);
		
		int n4 = 0xA5;//16진수 접두어: 0x
		System.out.println(n4);
		
		System.out.println(n << 1);//왼쪽으로 비트 이동중 2bit 이동
		System.out.println(n << 2);// 4bit
		System.out.println(n << 3);// 8bit
		System.out.println(n << 4);// 16bit
		System.out.println(n >> 1);// 오른쪽으로 이동중 
		System.out.println(n >> 2);
		System.out.println(n >> 3);
		System.out.println(n >> 4);//음수를 이동해도 부호가 바뀌지는 않는다. 
	}

}
