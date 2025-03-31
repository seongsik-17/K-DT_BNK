package week5;

public class TestMain {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Student();
		
		Student s1 = new Student();
		Worker w1 = new Worker();
		
		//Person[] person = new Person[3];
		//Student[] student = new Student[3];
		
		Person[] people = new Person[3];
		
		people[0] = p1;
		people[1] = s1;
		people[2] = w1;
		
		Student x = (Student)people[1];
		x.num = 2;
		System.out.println(x.num);
		
		
		
	
		
		
		
	}

}
