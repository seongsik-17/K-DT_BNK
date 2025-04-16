package c06;

public class HumanCamp2 {
	private int speed = 10;
//	public Unit getMarine() {
//		class Marine2 implements Unit{
//			@Override
//			public void move() {
//				System.out.println("인간형 유닛이 "+speed+" 속도로 움직입니다");
//				
//			}
//		}
//		return new Marine2();
//	}

	public Unit getMarine() {
		return new Unit() {
			@Override
			public void move() {
				System.out.println("인간형 유닛이 " + speed + " 속도로 움직입니다");

			}
		};
	}

}
