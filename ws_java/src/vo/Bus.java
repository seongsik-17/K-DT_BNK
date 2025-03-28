package vo;

public class Bus {
	int bus_num;// 버스번호
	int passinger;//승객 수
	int money_sum;//버스가 받은 요금 총액
	
	
	public Bus(int bus_num) {
		this.bus_num = bus_num;
	}
	
	
	
	public void take(int price) {
		money_sum += price;
		passinger++;
		
	}



	@Override
	public String toString() {
		return "Bus [bus_num=" + bus_num + ", passinger=" + passinger + ", money_sum=" + money_sum + "]";
	}
	
	

}
