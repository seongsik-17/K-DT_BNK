package week5;

import vo.BusanTravel;
import vo.T_Bus;
import vo.Train;
import vo.Trancepotation;

public class TravelTest {

	public static void main(String[] args) {
		//콘솔에 버스를 타고 부산여행을 간 결과로 '부산행 배스에 몸을 싣고...' 출력
		//콘솔에 기차를 타고 부산 여행을 간 결과로'부산행 기차에 몸을 싣고...' 출력 
		BusanTravel bt = new BusanTravel();
		T_Bus bus = new T_Bus();
		Train t = new Train();
		
		Trancepotation T = new Trancepotation();
		T.goBusan(bus);
		T.goBusan(t);
		//추상메서드를 상속받는건 반드시 지켜야하는 약속,반드시 기능을 구현해야함
		
		
		
	}

}
