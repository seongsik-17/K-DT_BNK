package vo;

public class Person_n {
	public String name;
	public int age;
	public double kg;
	//먹다라고 하는 함수
	public Person_n(String name,int age,double kg){
		this.name = name;
		this.age = age;
		this.kg = kg;
		
	}
	public void take(Eat e) {
	
		
	}
	
	public void nameage() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(kg);
	}
	
	

}
