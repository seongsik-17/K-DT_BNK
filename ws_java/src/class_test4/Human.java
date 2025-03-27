package class_test4;

import java.util.Arrays;
import java.util.Random;

public class Human {
	// number는 사람마다 다 다름 -> 인스턴스 변수
	// 번호는 인스턴스가 생성할 때 자동으로 부여됨 
	// 메모리에 생성자가 얼마나 만들어졌는지 확인 가능하게 없을 때는 0명
	int humanNum;// 인스턴스가 생성되는 대로 늘어나야하는 변수
	static int id;// 인스턴스와 관계없이 존재하는 변수
	// 성별을 받는 변수
	static char M;
	static char F;
	public char gender;

	public Human(char gender) {
		humanNum = id + 1;
		// System.out.println("고유번호>> "+humanNum);
		id++;
		this.gender = gender;

	}

	public char getGender() {

		return gender;
	}

	public int gethumanNum() {
		return humanNum;
	}

	static void count() {
		System.out.println("생성된 인간 클래스 인스턴수 갯수>> " + id + "개");
		System.out.println("");

	}

}
