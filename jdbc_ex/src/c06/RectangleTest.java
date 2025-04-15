package c06;

import java.util.HashSet;

public class RectangleTest {

	public static void main(String[] args) {
		Rectangle org = new Rectangle(1,1,9,9);
		Rectangle cpy = null;
		HashSet<Rectangle> rclist = new HashSet<>();
		
		try {
			cpy = (Rectangle)org.clone();//얕은 복사
			
			org.showPosition();
			cpy.chagePos(3,3,5,5);
			cpy.showPosition();
			org.showPosition();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		rclist.add(org);
		rclist.add(cpy);
		System.out.println("rclist_Size>> "+rclist.size());
		
		
		
	}

}
