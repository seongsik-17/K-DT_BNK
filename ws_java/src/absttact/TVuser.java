package absttact;

public class TVuser {

	public static void main(String[] args) {
		TV tv1 = new SamsungTV();
		TV tv2 = new LgTV();
		
		TV tv_arr[] = new TV[2];
		
		tv_arr[0] = tv1;
		tv_arr[1] = tv2;
		
		for(int i = 0; i < tv_arr.length; i++) {
			tv_arr[i].powerON();
			tv_arr[i].powerOff();
			tv_arr[i].volumeUp();
			tv_arr[i].volumeDown();
		}
		
		BeanFactory factory = new BeanFactory();
		TV tv3 = factory.getBean(3);//1이면 삼성Tv, 2면 LGTV가 작동되도록 하세요
		if(tv3 == null) {
			System.out.println("해당하는 TV가 없습니다.");
		}
		else {
			tv3.powerON();
			tv3.powerOff();
			tv3.volumeUp();
			tv3.volumeDown();
		}
		
	}

}
