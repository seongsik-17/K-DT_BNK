package vo;

import java.util.Arrays;

public class Myintarr {
	private int arr[];

	// 기본 생성자를 써서 정수를 5개 저장가능한 배열을 만들어서 멤버변수에 할당
	// getter역할을 하는 메서드를 만들기
	// 배열 안에 있는 값을 가져와야 하니까 getter에 매게변수를 가져야한다ㅓ
	// 특정한 요소를 저장하는 settr 함수
	// 배열의 모든값을 출력하는 함수
	public Myintarr() {
		this.arr = new int[5];
	}

	public void getter(int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				System.out.println("배열" + i + "번째에 있음");
			}
		}
		

	}

	public void setter(int point, int num) {
		arr[point] = num;
	}

	public void showInfo() {
		System.out.println(Arrays.toString(arr));
	}

}
