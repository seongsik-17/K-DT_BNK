package c07;

import lombok.Data;

@Data
public class User {
	private int uno;
	private String name;
	private String gender;
	private Rank rank;
	
	public void pay(int price) {
		System.out.println(rank.getKorName()+" "+name+"씨는 "+(int)(price*rank.getDiscountRate())+"원을 지불했습니다.");
		System.out.println("기존 가격>> "+price);
		System.out.println("할인금액>> "+(int)(price-(price*rank.getDiscountRate())));
		
	}
	

}
