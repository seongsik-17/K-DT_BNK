package c06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSortTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동","전우치","손오공","멀린");//이 형태로 배열을 생성하면 불변 배열이 생성된다 읽기 전용
		for(String s: list) {
			System.out.println(s+ "\t");
		}
		//ist.add("aaa");
		list = new ArrayList<>(list);
		list.add("aaa");
		for(String s: list) {
			System.out.print(s+ "\t");
		}
		Collections.sort(list);//ASC로 정렬되는 것이 기본값(오름차순)
		System.out.println();
		for(String s:list) {
			System.out.print(s + "\t");
		}

	}

}
