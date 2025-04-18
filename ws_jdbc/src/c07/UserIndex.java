package c07;

public class UserIndex {

	public static void main(String[] args) {
		Rank r = Rank.BRONZE;
		User u = new User();
		u.setUno(1);
		u.setName("홍길동");
		u.setGender("MALE");
		u.setRank(r);
		
		u.pay(200000);
		

	}

}
