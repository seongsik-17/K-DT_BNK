package absttact;

public class Ibtestmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IB ib = new B();
		IB ib2 = new C();
		
		IB[] ib_arr = new IB[2];
		
		ib_arr[0] = ib;
		ib_arr[1] = ib2;
		
		for(int  i = 0; i < ib_arr.length; i++) {
			ib_arr[i].f1();
			ib_arr[i].f2();
			
		}
		
		
		

	}

}
