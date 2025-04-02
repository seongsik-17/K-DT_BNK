package vo;

public class Ramen extends Eat {

	public Ramen(){
		
	}
	public void take(Person_n p) {
		System.out.println("라면을 먹습니다.");
		p.kg = p.kg + 5;
		
	}
	

}
