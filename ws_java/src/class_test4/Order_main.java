package class_test4;

public class Order_main {

	public static void main(String[] args) {
		Member mb = new Member();
		mb.setId("abc123");
		mb.setName("홍길순");
		mb.setAdrres("서울시 영등포구 여의도동 20번지");
		
		Order od = new Order("202503280001", "2025년 03월 28일", "PD0345-12", mb);
		System.out.println(od.toString());
		
		System.out.println(mb.toString());

	}
}
