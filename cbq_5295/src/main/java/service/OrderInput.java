package service;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Order;
import vo.OrderDao;


@WebServlet("/orderin")
public class OrderInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order or = new Order();
		or.setOrderno(request.getParameter("orderno"));
		or.setShopno(request.getParameter("shopno"));
		or.setOrderdate(request.getParameter("orderdate"));
		or.setPcode(request.getParameter("pcode"));
		or.setAmount(Integer.parseInt(request.getParameter("amount")));
		
		OrderDao od = new OrderDao();
		
		
		if(od.insert(or) == 1) {
			response.sendRedirect("index.jsp");
		}
		
		
		
	}

}
