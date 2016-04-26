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

public class CheOutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CheOutServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String roomId = request.getParameter("roomId");
		//根据退房的房间号退房
		HomeDaoImpl homeDaoImpl  = new HomeDaoImpl();
		Home home = homeDaoImpl.queryHomeByHomeNumber(roomId);
		
		if(!(home.getHomeState()==Home.HOMESTATE_EMPTY)){
		String idNumber = home.getCustomerIdNumber();

		home.setHomeState(Home.HOMESTATE_EMPTY);
		home.setCanCheckin(true);
		home.setCustomerIdNumber(null);
		homeDaoImpl.updateHomeById(home);
		
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		Customer customer = customerDaoImpl.queryCustomerByIdNumber(idNumber);
		customer.setHomeNumber(null);
		customer.setState(Customer.CUSTOMER_STATE_LEAVE);
		customerDaoImpl.updateCustomerByIdNumber(customer);
		
		List<Home> homes = homeDaoImpl.queryAllHomes();
		request.setAttribute("homes", homes);
		request.setAttribute("show", "1");
		request.setAttribute("message", "操作成功！");
		request.getRequestDispatcher("/manage.jsp").forward(request, response);
		}else{
			List<Home> homes = homeDaoImpl.queryAllHomes();
			request.setAttribute("homes", homes);
			request.setAttribute("show", "1");
			request.setAttribute("message", "操作失败！");
			request.getRequestDispatcher("/manage.jsp").forward(request, response);
			
		}
		
		
		
		
	}

	public void init() throws ServletException {
		
	}

}
