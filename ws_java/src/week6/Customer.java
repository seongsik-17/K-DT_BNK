package week6;



public class Customer extends Client{
	
	String cu_num;
	String cu_name;
	String cu_phone;
	int cu_sum;
	
	String vip_no;
	String vip_name;
	String vip_phone;
	int vip_sum;
	double vip_point;
	
	Customer(String cu_num, String cu_name, String cu_phone, int cu_sum ){
		this.cu_num = "C"+cu_num;
		this.cu_name = cu_name;
		this.cu_phone = cu_phone;
		this.cu_sum = cu_sum;
		
		if(cu_sum > 1000000) {
			System.out.println("vip회원으로 전횐되었습니다.");
			vip_no = "V"+cu_num;
			vip_name = cu_name;
			vip_phone = cu_phone;
			vip_sum = cu_sum;
			vip_point = cu_sum*0.05;
		}
		
		
	}

	@Override
	public String toString() {
		return "Customer [cu_num=" + cu_num + ", cu_name=" + cu_name + ", cu_phone=" + cu_phone + ", cu_sum=" + cu_sum
				+ "]";
	}
	
	
	
	
	
 
	

	

}
