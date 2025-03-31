package week5;

public class Area_main {

	public static void main(String[] args) {
		Area[] area = new Area[3];
		
		Calc_area c1 = new Calc_area();
		
		Ractangle r = new Ractangle(10,10);
		Triangle t = new Triangle(5,10);
		Cercle c = new Cercle(3);
		
		area[0] =r;
		area[1] = t;
		area[2] = c;
		
		c1.calc(r);
		c1.calc(c);
		c1.calc(t);
		
		
		
		

	}

}
