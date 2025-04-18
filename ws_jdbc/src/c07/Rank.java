package c07;

public enum Rank {
	GOLD("골드회원", 0.9), SILVER("실버회원", 0.95), BRONZE("브론즈회원", 0.98);
	private final String korname;
	private final double discountRate;
	
	Rank(String korname, double discountRate){
		this.korname = korname;
		this.discountRate = discountRate;
	}
	public String getKorName() {
		return korname;
	}
	public double getDiscountRate() {
		return discountRate;
	}
	public int discount(Rank r, int price) {
		
		return 0;
	}
}
