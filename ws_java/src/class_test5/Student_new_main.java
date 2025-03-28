package class_test5;

import vo.Bus;
import vo.Student_new;

public class Student_new_main {

	public static void main(String[] args) {
		Bus bus = new Bus(101);
		Student_new st = new Student_new("jeamse",2,10000);
		Student_new st1 = new Student_new("honk",1,10000);
		
		st.takeBus(bus);
		st1.takeBus(bus);
		
		
		System.out.println(bus.toString());
		System.out.println(st.showInfo());
		System.out.println(st1.showInfo());
		
		

		
		

	}

}
