package r14;

public class TypeTest {

	public static void main(String[] args) {
		TypeInt ti = new TypeInt();
		TypeFloat tf = new TypeFloat();
		TypeString ts = new TypeString();
		//열면 값이 바로 나오는건 원시 자료형
		//열었더니 자료의 주소값이 나오는건 참조자료형
		
		ti.i = 10;
		ti.setS(ts);
		
		TypeInt[] ti_arr = new TypeInt[3];
		
		ti_arr[0] = ti;
		//ti_arr[1] = tf;//자료형이 달라서 못씀
		//ti_arr[2] = ts;//자료형이 달라서 못씀
		//다른 자료형들을 배열로 사용하고 싶어서 상속을 사용한다.
		Datatype[] dt = new Datatype[3];
		dt[0] = ti;
		dt[1] = tf;
		dt[2] = ts;//자료형이 달라도 상속으로 같은 타입 지정
		f(ti);
		
		TypeObject to = new TypeObject();
		to.o = tf;
		TypeFloat x = (TypeFloat)to.o;
		x.f = 4.3f;
		//제네릭은 아무타입이나 받지만 생성자 만들때 자료형을 받음
		Typegeneric<String> tg = new Typegeneric();
		tg.t = "어쩔티비";
		System.out.println(tg.t);
		

	}
	public static void f(Typesample n) {//인터페이스도 자료형
		//자료형의 유연성을 가지기위해 인터페이스 추상메서드 등을 사용
		
	}

}
