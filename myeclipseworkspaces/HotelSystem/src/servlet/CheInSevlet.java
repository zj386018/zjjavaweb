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

public class CheInSevlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CheInSevlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String name = request.getParameter("username");
		String phone = request.getParameter("phone");
		String roomId = request.getParameter("roomId");
		String IdCard = request.getParameter("IdCard");
		
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		Customer customer = customerDaoImpl.queryCustomerByIdNumber(IdCard);
		
		HomeDaoImpl homeDaoImpl = new HomeDaoImpl();
		Home home = homeDaoImpl.queryHomeByHomeNumber(roomId);

		if(home.getHomeState()==Home.HOMESTATE_EMPTY){
			if(customer == null){
				customer = new Customer();
				customer.setIdNumber(IdCard);
				customer.setName(name);
				customer.setHomeNumber(roomId);
				customer.setPhoneNumber(phone);
				customer.setState(Customer.CUSTOMER_STATE_LIVEIN);
				customerDaoImpl.insertCustomer(customer);
				
				home.setCustomerIdNumber(IdCard);
				home.setHomeState(Home.HOMESTATE_CHECKIN);
				home.setCanCheckin(false);
				homeDaoImpl.updateHomeById(home);
			}else{
				customer.setIdNumber(IdCard);
				customer.setName(name);
				customer.setHomeNumber(roomId);
				customer.setPhoneNumber(phone);
				customer.setState(Customer.CUSTOMER_STATE_LIVEIN);
				customerDaoImpl.updateCustomerByIdNumber(customer);
				
				home.setCustomerIdNumber(IdCard);
				home.setHomeState(Home.HOMESTATE_CHECKIN);
				home.setCanCheckin(false);
				homeDaoImpl.updateHomeById(home);
				
				List<Home> homes = homeDaoImpl.queryAllHomes();
				request.setAttribute("homes", homes);
				request.setAttribute("show", "1");
				request.setAttribute("message", "操作成功！");
				request.getRequestDispatcher("/manage.jsp").forward(request, response);
			}
		}else{
			List<Home> homes = homeDaoImpl.queryAllHomes();
			request.setAttribute("homes", homes);
			request.setAttribute("show", "1");
			request.setAttribute("message", "该房间不是空闲的！");
			request.getRequestDispatcher("/manage.jsp").forward(request, response);
			
		}
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
