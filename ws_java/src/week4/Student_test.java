package week4;

public class Student_test {
	//클래스의 구성요소
	//1.멤버 변수(필드) - 클래스 안에 선언된 변수이므로 멤버변수라고 부른다.
	//2.멤버함수(메소드) - 클래스 안에 선언된 함수이므로 멤버함수라고 부른다.

	public static void main(String[] args) {
		//학생 3명의 인스턴스를 생성
		Student james = new Student();
		Student ann  = new Student();
		Student bread = new Student();
		
		james.no = 1;
		james.name = "james";
		james.kor_score = 90;
		james.eng_score = 90;
		james.math_score = 90;
		
		ann.no = 2;
		ann.name = "ann";
		ann.kor_score =80;
		ann.eng_score = 80;
		ann.math_score = 80;
		
		bread.no = 3;
		bread.name = "bread";
		bread.kor_score = 90;
		bread.eng_score = 70;
		bread.math_score = 60;
		
		
		int arr_kor[] = new int[3];
		arr_kor[0] = james.kor_score;
		arr_kor[1] = ann.kor_score;
		arr_kor[2] = bread.kor_score;
		
		String arr_name[] = new String[3];
		arr_name[0] = james.name;
		arr_name[1] = ann.name;
		arr_name[2] = bread.name;
		
		Student studnes[] = new Student[3];
		studnes[0] = james;
		studnes[1] = bread;
		studnes[2] = ann;
		
		int arr_eng[] = new int[3];
		arr_eng[0] = james.eng_score;
		arr_eng[1] = ann.eng_score;
		arr_eng[2] = bread.eng_score;
		
		int arr_math[] = new int[3];
		arr_math[0] = james.math_score;
		arr_math[1] = ann.math_score;
		arr_math[2] = bread.math_score;
		
		
		System.out.println(studnes[0].kor_score);
		
		
		
	}

}
