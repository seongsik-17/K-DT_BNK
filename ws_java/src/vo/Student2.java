package vo;

public class Student2 {
	// 이름 번호 국영수 성적
	String name;
	int no;
	int kor;
	int eng;
	int math;
	String PassFall;
	int rate;

	public Student2(String name, int no, int kor, int eng, int math) {
		this.name = name;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public int sum() {
		int sum = kor+eng+math;
		System.out.println(sum);
		return sum;
	}
	
	public int avg() {
		int avg = (kor+eng+math)/3;
		if(avg< 60) {
			PassFall = "유급";
			System.out.println(PassFall);
		}
		else {
			PassFall = "통과";
			System.out.println(PassFall);
		}
		return avg;
	}
	public void process() {
		avg();
		sum();
		
		
		
		
	}
	
	
	
	

	
}
