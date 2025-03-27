package class_test1;

public class Change_num {
	int no;//멤버 변수
	String name;
	char gender;

	
	void setNo(int a) {//세터:매게변수의 값을 설정 
		no  = a;
	}
	void setName(String n) {//멤버 함수 
		name = n;
	}
	
	int get_no() {
		System.out.println("현재 번호: "+no);
		return no;
	}
	String get_name() {
		System.out.println("현재 이름: "+name);
		return name;
	}
	char get_gender() {
		System.out.println("현재 성: "+gender);
		return gender;
	}

}
