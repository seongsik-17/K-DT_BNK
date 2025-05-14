package c06;

import java.util.List;

public class StreamFinalTest {

	public static void main(String[] args) {
		List<String> words = List.of("He", "hi", "wo");

		boolean result = words.stream()
							//.anyMatch(s -> s.length() < 3); -하나라도 만족하나?
							.allMatch(s -> s.length() < 3); //-Stream이 모두 만족하나?
		
		
		
		if (result) {
			System.out.println("있네");

		} else {
			System.out.println("없네");
		}

	}

}
