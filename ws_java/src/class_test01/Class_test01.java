package class_test01;

public class Class_test01 {

	public static void main(String[] args) {
		Student stu = new Student();
		Student stu1 = new Student(1,"james",'m');
		Student stu2 = new Student(2,"ann");		
		
		System.out.println(stu2.no);
		System.out.println(stu1.name);
		System.out.println(stu1.no);
		System.out.println(stu1.gender);
	}
}
//함수의 이름은 같고 시그니쳐만 다른 함수: 메서드 오버로딩!!!
//생성자는 클래스 인스턴스의 멤버변수들을 초기화 하는 용도로 쓰인다.
//기본 생성자의 사용여부를 결정하는건 정책으로 결정한다.(내부 규약)
//함수는 이름만으로 구별하지 않는다. 
//반환타입-함수이름-매개변수 = 함수의 시그니쳐(함수구별 기준)