package class_test4;

public class Order {
     String order_Num;
	 String order_date;
     String PD_Num;
     Member member;
    
    
	
	//setter, getter 필요함

	public Order(String order_Num,String order_date, String PD_Num,Member member){
		this.order_Num = order_Num;
		this.order_date = order_date;
		this.PD_Num = PD_Num;
		this.member = member;
		
	
	}

	public Member getMember() {
		return member;
	}
	
	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Order [order_Num=" + order_Num + ", order_date=" + order_date + 
				", PD_Num=" + PD_Num + ", member="+member.getName()
				+ member.getAdrres() + member.getId()+ "]";
	}
	
	
	

}
