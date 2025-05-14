package ex05.test;

public class A {
	private static A instance = new A();
	private A() {

	}
	public static A getInstance() {
		return instance;
	}
}
