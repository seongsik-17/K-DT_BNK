package vo;

public class Mydate_main {

	public static void main(String[] args) {
		
		Mydate time1 = new Mydate();
		time1.setYear(2021);
		time1.setDay(28);
		time1.setMonth(2);
		System.out.println(time1.toString());
		
		Mydate time2  = new Mydate();
		time2.setYear(2022);
		time2.setDay(31);
		time2.setMonth(4);
		System.out.println(time2.toString());
		
		Mydate time3  = new Mydate();
		time3.setYear(2300);
		time3.setDay(0);
		time3.setMonth(11);
		System.out.println(time3.toString());
		
		
		
		
		
	}

}
