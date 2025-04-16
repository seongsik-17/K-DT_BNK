package test_java;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Generic_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> map = new HashMap<>();
		
		// key
		//
		//Resist r = new Resist();

		map.put("move", "움직이다");
		map.put("kick", "차다");
		map.put("Apple", "사과");
		map.put("Banana", "바나나");
		map.put("melon", "메론");
		map.put("java", "자바");
		map.put("shut down", "영업정지");

		System.out.print("단어를 입력해주세요>> ");
		String key = sc.nextLine();
		//System.out.println("입력한 단어>> " + key + "\n" + "Eng->kor>> " + r.map.get(key));
		
		
		
		
		

	}

}
