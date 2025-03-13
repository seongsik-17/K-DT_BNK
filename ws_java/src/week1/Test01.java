package week1;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//기초 출력문
				System.out.println("Hello Java!");
				System.out.println("Hello Java!");
				
				//a+b를 c를 통해 출력
				int a = 150000;
				int b = 2356;
				int c = a + b;
				
				System.out.println(c);	
				
				//홀짝 판별기
				
				int n = 5782;
				String result;
				
				if(n % 2 == 0) {
					result = "짝수입니다!";
				}
				else
					result = "홀수입니다!";
				
				System.out.println(result);
				
				//대소비교
				int n1 = 1234;
				int n2 = 123;
				
				if(n1==n2)System.out.println("n1과 n2는 같은 수");
				else
					if(n1 > n2)System.out.println("n1이 더 크다");
					else
						System.out.println("n2가 더 크다");
				
				//3가지 수를 비교
				int r1 = 7;
				int r2 = 9;
				int r3 = 5;
				
				if(r1 > r2) {
					if(r1 > r3)System.out.println("r1이 제일 큰 수");
					else
						System.out.println("r3가 제일 큰 수");
				}
				else if(r2 > r3)System.out.println("r2가 제일 큰 수");
				else
					System.out.println("r3가 제일 큰 수");
				
				//반복문( while(조건식) ) 조건식이 거짓이 될 때 까지 반복한다.
				int m = 1;
				while(m<=5) {
					System.out.println("Hello");
					m = m+1;
				}
				
			
				
				
	}

}
