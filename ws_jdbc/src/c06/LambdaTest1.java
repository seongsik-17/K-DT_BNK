package c06;

public class LambdaTest1 {
	public static void main(String[] args) {
//		Unit unit = new Human();
//		unit.move();
		
//		Unit unit = new Unit() {//익명 클래스
//			@Override
//			public void move() {
//				System.out.println("인간이 움직인다구요...");
//			}
//		};
//		unit.move();
		
//		Unit2 unit = (s,i) -> {System.out.println(s);
//		                   System.out.println(i);};
//		
//		}
//		unit.move("Move move");
		Unit2 unit = (s) -> {return s.length();};
		int result = unit.move("move move");
		System.out.println(result);
			
		
		
	}

}
