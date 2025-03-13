package week2;

public class Test09 {

	public static void main(String[] args) {
		//중첩 반복문
		for(int i = 0;i < 3; i++) {
			System.out.println("바깥쪽 반복문 실행..."+(i+1));//카톡 대화방 
			for(int k = 0;k < 5;k++) {
				System.out.println("\t안쪽 반복문 실행..."+ (k+1));
			}
		}
		
		//구구단을 외우자!
		for(int i = 2; i < 10; i++) {//단수 출력
			System.out.print(i+"단을 외우자\t");
		}
		for(int i = 1; i < 10; i++) {//j * i = j*i

			System.out.println("");
			for(int j = 2; j < 10; j++) {
				System.out.print(j+" * "+i+" = "+(i*j)+"\t");
			}
		}

	}

}
