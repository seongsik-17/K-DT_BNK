package week6;

import java.util.ArrayList;

public class Generic_test {

	public static void main(String[] args) {
		Box<String> box  = new Box<>();
		//생성될 때 String으로 생성됨
		
		box.t = "hello";
		
		System.out.println(box.t);
		
		Box<X> xbox = new Box<>();
		xbox.t = new X();
		
		xbox.t.x = 10;//멤버변수의 자료형을 따른다
		
		System.out.println(xbox.t.x);
		
		
		ArrayList<Integer>sList = new ArrayList<>();
		ArrayList<String>sList2 = new ArrayList<>();
		ArrayList<Character>sList3 = new ArrayList<>();
		ArrayList<Float>sList4 = new ArrayList<>();
		sList2.add("aaaa");
		sList.add(1234);
		sList3.add('e');
		

	}

}
