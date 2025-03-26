package vo;

public class Mydate {
	//날짜 정보를 받는 클래스
	//년, 월, 일
	private int year;
	private int month;
	private int day;
	
	
	Mydate(){
		//기본 생성자 생성
	}
	//setter_start
	public void setYear(int year) {
		this.year = year;
	}
	public void setMonth(int month) {
		cheakDay(month);
	}
	public void setDay(int day) {
		this.day = day;
	}
	//setter_end
	
	
	private void cheakDay(int month) {//2월일 때 28일을 초과하는지 검사하는 멤버함수
		if(month == 2) {
			if(day ==0 || day > 28) {
				System.out.println("범위를 벗어났습니다!");
			}
		}
		else if(month % 2 != 0) {
			if(day ==0 || day > 31) {
				System.out.println("범위를 벗어났습니다!");
			}
		}
		else {
			if(day ==0 || day>30) {
				System.out.println("범위를 벗어났습니다!");
			}
		}
		this.month = month;
	}
	@Override
	public String toString() {
		return "Mydate year=" + year + ", month=" + month + ", day=" + day ;
	}
	
	

}
