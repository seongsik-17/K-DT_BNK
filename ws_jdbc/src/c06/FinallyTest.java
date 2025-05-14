package c06;

public class FinallyTest {
	public static void main(String[] args) {
		System.out.println("START");
		try{//해야할 일(기능)
		String s = "abc";
		System.out.println(s.charAt(0));
		}
		catch(NullPointerException e) {
			System.out.println("*************************");
			System.out.println("경고!)s에 문자열이 담겨있지 않아요!");
			System.out.println("*************************");
		}
		finally {
			System.out.println("반드시... 해야 할일을 하지");
		}
		System.out.println("END");
			
		
		
		

	}
}
