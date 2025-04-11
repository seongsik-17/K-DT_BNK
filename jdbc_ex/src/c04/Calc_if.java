package c04;

public interface Calc_if {
	public int add(int a, int b);
	public int minus(int a, int b);
	public int multi(int a, int b);
	public double division(int a, int b);
	public default int power (int a) {
		return a*a;
	}
	

}
