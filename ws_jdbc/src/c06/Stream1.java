package c06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Stream1 {
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		
		//1.스트림 생성
		IntStream stm1 = Arrays.stream(arr);//arr자료가 int형이라서 IntStream이다.
		//2.중간 연산
		IntStream stm2 = stm1.filter(n -> n%2 == 1);
		//3.최종 연산
		int sum = stm2.sum();
		
		System.out.println(sum);
		//stream = 데이터의 흐름 자체를 스트림이라고 한다. 단방향으로 움직임 
		//Stream연산은 기존 자료를 변경하지 않는다. Collections는 원본 데이터가 바뀐다.
		
		int sum2  = Arrays.stream(arr).filter(n -> n%2 == 0).sum();
		System.out.println(sum2);//한줄로 연결된 특성 때문에 메서드 체이닝이라고도 한다.
		
		List<String> list =  Arrays.asList("홍길동","임꺽정","해리포터");
		
		list.stream()
		.sorted()
		.forEach(n -> System.out.println(n + "\n"));//요소를 하나씩 꺼내어서 출력
		
		list.stream()
		.sorted((s1,s2) -> s1.length() - s2.length())
		.forEach(n -> System.out.println(n + "\t"));
		
		
		

	}
}
