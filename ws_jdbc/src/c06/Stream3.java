package c06;

import java.util.stream.IntStream;

public class Stream3 {

	public static void main(String[] args) {
		int sum = IntStream.of(1,3,5,7,9).sum();
		System.out.println("sum: "+ sum);
		
		long count = IntStream.of(1,3,5,7,9).count();
		System.out.println("count: "+count);
	}

}
