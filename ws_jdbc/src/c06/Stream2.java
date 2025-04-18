package c06;

import java.util.Arrays;
import java.util.List;

public class Stream2 {
	public static void main(String[] args) {
		
		
		List<String> list1 = Arrays.asList("Apple", "Banana", "Orange");
		//filter : 조건에 맞는 자료들 추출하기**
		//map: 자료를 특정한 형태로 변환하기**
		//collect(): 콜렉션 자료 만들어 반환**
		//forEach(): 각 요소에 대한 작업 수행**
		list1.stream()
		.filter(s -> s.startsWith("A"))
		.filter(s -> s.endsWith("e"))
		.map(s -> s.toUpperCase())
		.forEach(n -> System.out.println(n+"\t"));
		
		

	}
}
