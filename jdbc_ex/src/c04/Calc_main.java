package c04;

public class Calc_main {

	public static void main(String[] args) {
		Calc2 c2 = new Calc2();
		c2.add(1, 2);
		c2.minus(5, 3);
		System.out.println(c2.absolute(-7));
		System.out.println(c2.power(5));
		

	}

}
