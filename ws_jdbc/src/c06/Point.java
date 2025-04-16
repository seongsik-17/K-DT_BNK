package c06;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Point implements Cloneable {
	private int xPos;
	private int yPos;
	
	public Point(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void showPosition() {
		System.out.printf("[%d,%d]",xPos,yPos);
		System.out.println();
	
	}
	
	@Override//protected - 상속 관계에서 접근
	public Point clone() throws CloneNotSupportedException {
		//클래스의 인스턴스를 복제하기 위해서 사용하는 함수 -> 똑같은 놈을 만들어줌
		
		return (Point)super.clone();
	}

	public void changePos(int x, int y) {
		xPos = x;
		yPos = y;
		
	}

}
