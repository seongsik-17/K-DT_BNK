package week5;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		String s1 = "abcdefg";
		String s2 = "Hello";
		// 스트링 타입에 할당된건 변경이 불가능하다. -> 변경 시도시 다른 주소로 넘어감
		// 한번 결정되면 불변!!

		System.out.println(s1 == s2);
		String s3 = new String("Hello");
		System.out.println(s1 == s3);
		System.out.println(s1.equals(s3));
		// equals는 요소값을 비교하는 구문임 - String클래스의 멤버함수
		char c = s1.charAt(1);// String을 배열처럼 처리가능
		System.out.println(c);

		char[] arr = new char[s1.length()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = s1.charAt(i);
			System.out.print(arr[i] + " ");
		}
		// 문자열에서 원하는 범위의 값을 추출해주는 멤버함수
		System.out.println(s1.length());
		System.out.println(s1.substring(0, 5));
		System.out.println(s1.contains("def"));//있는지 확인하는 함수

		// indexOf()
		int a = s1.indexOf("de");// 내부 요소가 몇번째부터 시작하는지 알려줌
		System.out.println(a);

		// equals()
		String str1 = "Java";
		String str2 = "java";

		System.out.println(str1 == str2);
		System.out.println(str1.equalsIgnoreCase(str2));// 대소문자는 구분하지 않고 문자열을 비교해보자

		System.out.println(str1.toUpperCase());// 기존의 문자열을 수정하는것이 아니라 새로운 문자열을 생성
		System.out.println(str1.toLowerCase());

		String newStr = str1.trim();// 문자열에서 공백을 없애주는 함수
		System.out.println(newStr.length());

		// replace
		String x = str2.replace("ja", "go");// "ja"부분을 "go"로 바꿔주는 부분
		System.out.println(x);

		// split()
		String k = "aaa,bbb,ccc,ddd";
		String[] arr_k = k.split(",");// 매개변수 자리를 기준으로 분리
		for (int i = 0; i < arr_k.length; i++) {
			System.out.println(arr_k[i]);
		}

	}

}
