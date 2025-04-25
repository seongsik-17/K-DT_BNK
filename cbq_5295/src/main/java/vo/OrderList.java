package vo;

import lombok.Data;

@Data
public class OrderList {
	private String shopno;
	private String shopname;
	private String orderno;
	private String orderdate;
	private String pcode;
	private String pname;
	private int amount;
	private int cost;
	private int msrp;
	private int dismsrp;

}
