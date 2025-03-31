package week5;

public class Calc_area extends Area {
	void calc(Area area) {
		if (area instanceof Ractangle) {
			Ractangle r = (Ractangle) area;
			System.out.println("사각형의 면적>> " + (r.weidth * r.height));

		} else if (area instanceof Triangle) {
			Triangle t = (Triangle) area;
			System.out.println("삼각형의 면적>> " + (t.bottom * t.height) / 2);
		} else if (area instanceof Cercle) {
			Cercle c = (Cercle) area;
			System.out.println("원의 면적>> " + ((c.r) * (c.r)) * 3.14);
		}

	}

}
