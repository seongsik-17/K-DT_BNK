package vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connect.DBcon;

public class OrderDao {
	Connection conn = DBcon.getConnection();
	PreparedStatement pstmt;
	ResultSet rs;

	public int insert(Order o) {
		int result = 0;
		String query = "INSERT INTO tbl_order_202101 VALUES(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, o.getOrderno());
			pstmt.setString(2, o.getShopno());
			pstmt.setString(3, o.getOrderdate());
			pstmt.setString(4, o.getPcode());
			pstmt.setInt(5, o.getAmount());// 주문수량

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQL삽입 실패!");
			e.printStackTrace();
		}
		return result;

	}

	public List<OrderList> selectlist() {

		List<OrderList> list = new ArrayList<>();
		String query = "SELECT s.shopno, s.shopname, o.orderno, o.orderdate, p.pcode, p.pname,o.amount, p.cost,(o.amount*p.cost)AS msrp\r\n"
				+ ",(p.cost * o.amount*s.discount)-(o.amount*p.cost) AS dismsrp\r\n"
				+ "FROM tbl_product_202101 p, tbl_order_202101 o, tbl_shop_202101 s\r\n"
				+ "WHERE s.shopno = o.shopno AND o.pcode = p.pcode\r\n" + "ORDER BY o.orderno";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				OrderList orlist = new OrderList();
				orlist.setShopno(rs.getString("shopno"));
				orlist.setShopname(rs.getString("shopname"));
				orlist.setOrderno(rs.getString("orderno"));
				orlist.setOrderdate(rs.getString("orderdate"));
				orlist.setPcode(rs.getString("pcode"));
				orlist.setPname(rs.getString("pname"));
				orlist.setAmount(rs.getInt("amount"));
				orlist.setCost(rs.getInt("cost"));
				orlist.setMsrp(rs.getInt("msrp"));
				orlist.setDismsrp(rs.getInt("dismsrp"));
				
				list.add(orlist);

			}

		} catch (SQLException e) {
			System.out.println("데이터 로딩 실패!!");
			e.printStackTrace();
		}
		return list;

	}
	//점포별 주문현황
	public List<OrderStatus> selectorderlist(){
		
		List<OrderStatus>list = new ArrayList<>();
		String query = "SELECT o.shopno, p.pcode, p.pname,SUM(o.amount)AS totalorder\r\n"
				+ "FROM tbl_product_202101 p, tbl_order_202101 o\r\n"
				+ "WHERE o.pcode = p.pcode \r\n"
				+ "GROUP BY o.shopno, p.pcode, p.pname";
		try {
			pstmt=conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderStatus ods = new OrderStatus();
				ods.setShopno(rs.getString("shopno"));
				ods.setPcode(rs.getString("pcode"));
				ods.setPname(rs.getString("pname"));
				ods.setTotalorder(rs.getInt("totalorder"));
				
				list.add(ods);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	public List<PcodeSelect> pcodeselect(){
		List<PcodeSelect> list = new ArrayList<>();
		String query = "SELECT pcode,pname,cost,(cost*0.9)AS ten, (cost*0.85)AS fiftin\r\n"
				+ "FROM tbl_product_202101";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PcodeSelect ps = new PcodeSelect();
				ps.setPcode(rs.getString("pcode"));
				ps.setPname(rs.getString("pname"));
				ps.setCost(rs.getInt("cost"));
				ps.setTen(rs.getInt("ten"));
				ps.setFiftin(rs.getInt("fiftin"));
				
				list.add(ps);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
		
	}
}
