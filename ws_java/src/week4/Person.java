package week4;

public class Person {
	String name;
	int age;
	char gender;
	
	Person(){}
	
	Person(String name){
		this.name = name;
		System.out.println("1번째 생성자");
	}
	
	Person(int age){
		this.age = age;
	}
	
	Person(char gender){
		this.gender = gender;
	}
	
	Person(String s, int n){
		
		
	}
	
	Person(String s, char g){
		
	}
	
	Person(int n, char g){
		
	}
	
	Person(String name, int age, char gender){
		this(name, age);
		this.gender = gender;
		
	}
	

	
}
