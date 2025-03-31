package week5;

public class Cercle extends Area {
	
	double r;
	double area;
	
	Cercle(double r){
		this.r = r;
	}
	
	/*void calc() {
		area = ((r)*(r))*3.14;
		
	}*/

	void out() {
		System.out.println(area);
	}
	
	
}
