package class_test5;

import vo.Student2;

public class Score_process_main {

	public static void main(String[] args) {
	Student2 st = new Student2("일식",1,80,80,80);
	Student2 st1 = new Student2("이식",2,50,55,70);
	Student2 st2 = new Student2("삼식",3,80,60,70);
	Student2 st3 = new Student2("사식",4,20,100,70);
	Student2 st4 = new Student2("오식",5,50,60,80);
	
	st1.process();

	}

}
