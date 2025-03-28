package vo;

public class Student_new {
	String name;
	int grade;
	int money;
	
	
	
	
	
	public Student_new(String name, int grade, int money) {
		this.name = name;
		this.grade = grade;
		this.money = money;
		
	}
	
	public void takeBus(Bus bus) {
		money-=1000;
		bus.take(1000);
	}


	public String showInfo() {
		return "이름:" + name+"\n" + "학년:" + grade+"\n" 
	            +"가진돈:" + money+"\n" ;
	}
	
	
	

}
