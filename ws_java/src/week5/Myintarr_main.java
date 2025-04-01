package week5;

import vo.Myintarr;

public class Myintarr_main {

	public static void main(String[] args) {
		Myintarr my = new Myintarr();//기본 생성자로 배열 생성(5칸)
		
		my.setter(0, 5);
		my.setter(1, 2);
		my.setter(2, 3);
		my.setter(3, 0);
		my.setter(4, 9);
		
		my.getter(3);
		
		my.showInfo();		
		
	}

}
