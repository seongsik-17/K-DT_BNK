package test_java;


import java.util.Scanner;

public class Generic_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// key
		//
		Resist r = new Resist();

		r.map.put("move", "움직이다");
		r.map.put("kick", "차다");
		r.map.put("Apple", "사과");
		r.map.put("Banana", "바나나");
		r.map.put("melon", "메론");
		r.map.put("java", "자바");
		r.map.put("shut down", "영업정지");

		System.out.print("단어를 입력해주세요>> ");
		String key = sc.nextLine();
		System.out.println("입력한 단어>> " + key + "\n" + "Eng->kor>> " + r.map.get(key));
		
		
		
		
		

	}

}
