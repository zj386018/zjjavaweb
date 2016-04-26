package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baiyi.hotelsystem.bean.Customer;
import com.baiyi.hotelsystem.bean.Home;
import com.baiyi.hotelsystem.dao.CustomerDaoImpl;
import com.baiyi.hotelsystem.dao.HomeDaoImpl;

public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public OrderServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return ;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String roomId = request.getParameter("roomId");
		String account = (String) request.getSession().getAttribute("username");
		
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		Customer customer = customerDaoImpl.queryCustomer(account);
		
		HomeDaoImpl homeDaoImpl = new HomeDaoImpl();
		Home home = homeDaoImpl.queryHomeByHomeNumber(roomId);
		
		if(home.getHomeState()==Home.HOMESTATE_EMPTY){
				if(null==customer.getHomeNumber()||customer.getHomeNumber().equals("null")){
				customer.setHomeNumber(roomId);
				customer.setState(Customer.CUSTOMER_STATE_BOOK);
				customerDaoImpl.updateCustomerByIdNumber(customer);
				
				home.setCustomerIdNumber(customer.getIdNumber());
				home.setHomeState(Home.HOMESTATE_BOOK);
				home.setCanCheckin(false);
				homeDaoImpl.updateHomeById(home);
				
				List<Home> homes = homeDaoImpl.queryAllHomes();
				request.setAttribute("homes", homes);
				request.setAttribute("show", "1");
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("/order.jsp").forward(request, response);
				}else{
					List<Home> homes = homeDaoImpl.queryAllHomes();
					request.setAttribute("homes", homes);
					request.setAttribute("show", "1");
					request.setAttribute("message", "您已预订了房间！每人只能预订一个房间！");
					request.getRequestDispatcher("/order.jsp").forward(request, response);
				}
		}else{
			List<Home> homes = homeDaoImpl.queryAllHomes();
			request.setAttribute("homes", homes);
			request.setAttribute("show", "1");
			request.setAttribute("message", "该房间不是空闲的！");
			request.getRequestDispatcher("/order.jsp").forward(request, response);
			
		}
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
