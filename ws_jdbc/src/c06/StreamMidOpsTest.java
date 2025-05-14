package c06;

import java.util.List;
import java.util.stream.Collectors;

public class StreamMidOpsTest {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(10, 20, 30, 40, 50, 60, 70);
		List<Integer> results = numbers.stream().skip(2)// 리스트 앞에 2개는 스킵
				.limit(3)// 3개 까지
				// .forEach(System.out::println)
				.collect(Collectors.toList());

		System.out.println(results);

		int x = results.stream().reduce(0, (a, b) -> a + b);
		System.out.println(x);

	}

}
