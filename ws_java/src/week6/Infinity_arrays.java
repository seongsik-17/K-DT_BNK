package week6;

public class Infinity_arrays {

	private Object[] objs;
	int i = 0;

	public Infinity_arrays() {
		objs = new Object[3];
	}

	// 배열에 데이터를 추가하는 함수
	public void add(String s) {
		objs[i] = s;
		i++;
		if (i == objs.length) {
			infi_arr();
		}
	}

	private void infi_arr() {// 배열 무한생성 함수
		Object[] objs2 = new Object[objs.length + 3];
		for (int i = 0; i < objs.length; i++) {
			objs2[i] = objs[i];
		}
		objs = objs2;
	}

	public void showArray() {
		for (int i = 0; i < this.i; i++) {
			System.out.println(objs[i]);
		}
	}

}
