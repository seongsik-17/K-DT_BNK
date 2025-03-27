package class_test1;

public class Student {
	int no;
	String name;
	char gender;
	
	Student(){
		//필요에따라 만들어쓰는 생성자
		//매게변수가 3개인 생성
	}
	Student(int n,String s,char c){
		no = n;
		name = s;
		gender = c;
	}
	Student(int no, String name){
		this.no =no;
		this.name = name;
	}
}
