package c06;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Rectangle implements Cloneable  {
	private Point upperLeft;
	private Point lowerRight;
	
	public Rectangle(int x1, int y1, int x2, int y2) {
		upperLeft = new Point(x1,y1);
		lowerRight = new Point(x2,y2);		
	}
	
	public void chagePos(int x1, int y1, int x2, int y2) {
		upperLeft.changePos(x1,y1);
		lowerRight.changePos(x2,y2);
		
	}
	public void showPosition() {
		System.out.print("좌측 상단: ");
		upperLeft.showPosition();
		System.out.print("우측 하단");
		lowerRight.showPosition();
		System.out.println();
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Rectangle rc = new Rectangle(upperLeft.getXPos(),upperLeft.getYPos(),lowerRight.getXPos(),lowerRight.getYPos());

		return rc;
	}
	
	
}
