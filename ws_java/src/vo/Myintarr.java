package vo;

import java.util.Arrays;

public class Myintarr {
	private int arr[];
	private int arr2[];
	int end;

	// 기본 생성자를 써서 정수를 5개 저장가능한 배열을 만들어서 멤버변수에 할당
	// getter역할을 하는 메서드를 만들기
	// 배열 안에 있는 값을 가져와야 하니까 getter에 매게변수를 가져야한다ㅓ
	// 특정한 요소를 저장하는 settr 함수
	// 배열의 모든값을 출력하는 함수

	// 배열의 요소를 삭제하는 함수
	// 삭제 메서드가 작동하면 배열을 읽어올 때 -1 해야함 -> 배열이 줄어듬
	// 추가 메서드:유효한 데이터 뒤에 추가된다. addInt(int n){

	public Myintarr() {//기본 생성자 생성
		this.arr = new int[5];

		end = arr.length;
	}

	public void getter(int num) {//배열 안에 원하는 요소를 찾는 함수
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				System.out.println("배열 " + i + "번째에 있음");
			} else if (i > (arr.length - 1)) {
				System.out.println("입력하신 수가 배열에 없습니다...");
				System.out.println("입력한 수: " + num);
			}
		}

	}

	public void setter(int point, int num) {// point번 배열을 num으로 설정
		arr[point] = num;
	}

	public void remover(int n) {// n번째 요소를 삭제하는 멤버함수
		for (int i = n; i < end; i++) {
			arr[i] = arr[i + 1];
			n += 1;
		}
		end -= 1;

	}

	public void remover_a() {
		end = 0;
		System.out.println("모든 배열이 삭제되었습니다...");
	}

	public void addInt(int n) {//배열에 요소를 넣는 함수
		if (end >= (arr.length - 1)) {
			this.arr2 = new int[arr.length + 5];
			for (int i = 0; i < arr.length; i++) {
				arr2[i] = arr[i];
			}
			arr = arr2;
		}
		arr[end] = n;
		end += 1;

	}

	public void showInfo() {// 배열 출력
		for (int k = 0; k < end; k++) {
			System.out.print(arr[k] + " ");
		}

		System.out.println("");
	}

	public void showPoint() {// 유효한 배열의 길이를 출력
		System.out.println("현재 유효한 배열의 길이>> " + end);
	}

}
