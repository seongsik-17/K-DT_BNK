package c06;

public class Point_Test {

	public static void main(String[] args) {
		Point org = new Point(3,5);
		Point cpy;
		
		
		try {
			cpy = org.clone();
			org.showPosition();
			cpy.showPosition();
			System.out.println("-----------------------");
			cpy.setXPos(10);
			cpy.setYPos(30);
			
			org.showPosition();
			cpy.showPosition();
			
			
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}

	}

}
