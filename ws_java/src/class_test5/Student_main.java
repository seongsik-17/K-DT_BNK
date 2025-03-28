package class_test5;

import vo.Persenal;
import vo.Student;

public class Student_main {

	public static void main(String[] args) {
		
		Student st = new Student();
		st.setGrade(2);
		st.setNumber(123);
		st.setDivison("이과");
		Persenal p1 = new Persenal("김철수",10,"123123","주소",st);
		
		
		
		
		System.out.println(p1.toString());
		
		
		
		
		

	}

}
