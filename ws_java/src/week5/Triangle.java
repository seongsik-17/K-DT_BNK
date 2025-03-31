package week5;

public class Triangle extends Area {
	
	int bottom;
	int height;
	

	int area;
	Triangle(int bottom, int height){
		this.bottom = bottom;
		this.height = height;
		
	}
	
	/*void calc() {
		area = (height*bottom)/2; 
		
	}/***/
	void out() {
		System.out.println(area);
	}
	
	

}
