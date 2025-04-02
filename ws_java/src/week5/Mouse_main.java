package week5;

import vo.Mouse;
import vo.Optical_Mouse;
import vo.WheelMouse;

public class Mouse_main {

	public static void main(String[] args) {
		Mouse[] mouse = new Mouse[3];
		
		Mouse m = new Mouse();
		WheelMouse w = new WheelMouse();
		Optical_Mouse o = new Optical_Mouse();
		
		mouse[0] = m;
		mouse[1] = w;
		mouse[2] = o;
		
		
		for(int i = 0; i < mouse.length; i++) {
			if(mouse[i] instanceof WheelMouse) {//getClass로 클래스 타입을 가져오기 가능, xxxx.Class로 비교 가
				WheelMouse wm = (WheelMouse)mouse[i];
				wm.scroll();
				
			}
			else {
				mouse[i].clickright();
				mouse[i].clickleft();
			}
			
			if(mouse[i].getClass() == Mouse.class) {
				System.out.println("Mouse 타입입니다.");
				System.out.println("-------------------");
			}
			else if(mouse[i].getClass() == WheelMouse.class) {
				System.out.println("WheelMouse 타입입니다.");
				System.out.println("-------------------");
			}
			else if(mouse[i].getClass() == Optical_Mouse.class) {
				System.out.println("Optical타입입니다.");
				System.out.println("-------------------");
			}
	
		}
		
		
		
	}

}
