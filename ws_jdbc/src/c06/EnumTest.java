package c06;

public class EnumTest {
	enum Day{
		MONDAY, TUESDAY, WENDSDAY, THURSDAY,FRIDAY,SATURDAY,SUNDAY 
	}

	public static void main(String[] args) {
		Day day = Day.MONDAY;
		
		switch(day) {
		case MONDAY-> {
			System.out.println("월요일");
			break;
		}
		case TUESDAY->{
			System.out.println("화요일");
			break;
		}
		case WENDSDAY->{
			System.out.println("수요일");
			break;
		}
		case THURSDAY->{
			System.out.println("목요일");
			break;
		}
		case FRIDAY->{
			System.out.println("금요일");
			break;
		}
		case SATURDAY->{
			System.out.println("토요일");
			break;
		}
		case SUNDAY->{
			System.out.println("내일은 출근이군 ㅎ");
			break;
		}
		}

	}

}
