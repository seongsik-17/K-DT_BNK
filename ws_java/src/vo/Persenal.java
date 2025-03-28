package vo;

public class Persenal {// 학생 개인정보
	private String name;
	private int age;
	private String ID_code;// 주민번호
	private String Adress;//주소
	Student student;

	public Persenal(String name, int age, String ID_code, String Adress,Student student) {
		this.name = name;
		this.age = age;
		this.ID_code = ID_code;
		this.Adress = Adress;
		this.student = student;
	}

	@Override
	public String toString() {
		return "이름: " + name+"\n" + "나이: " + age+"\n" + "식별번호: " + ID_code+"\n" + "주소: " + Adress+"\n" 
				+"학과: "+ student.getDivison()+"\n"+"학년: "+student.getGrade();
	}

	

	
}
