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

public class RegServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RegServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password1");
		String username = request.getParameter("username");
		String phone = request.getParameter("phone");
		String IdCard = request.getParameter("IdCard"); 
		
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		Customer customer = new Customer(account, password, username, phone, IdCard, 0, null);
		int check = customerDaoImpl.insertCustomer(customer);
		System.out.println(check);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		if(/*���֤�Ѵ������ݿ���*/check==2){
			String returnUrl = request.getContextPath() + "/register.jsp";
		      response
	          .getWriter()
	          .println(
	              "<script language=\"javascript\">alert(\"�����֤��ע����˺ţ���ֱ�����˺ŵ�½��\");" +
	              "if(window.opener==null){window.top.location.href=\""
	                  + returnUrl
	                  + "\";" +
	                  "}else{" +
	                  "window.opener.top.location.href=\""
	                  + returnUrl
	                  + "\";" +
	                  "window.close();" +
	                  "}</script>");
		      return;
		}
		else if(/*�˺ű�ע��*/check==1){
			String returnUrl = request.getContextPath() + "/register.jsp";
		      response
	          .getWriter()
	          .println(
	              "<script language=\"javascript\">alert(\"���˺��ѱ�ע�ᣡ������һ���µ��˺ţ�\");" +
	              "if(window.opener==null){window.top.location.href=\""
	                  + returnUrl
	                  + "\";" +
	                  "}else{" +
	                  "window.opener.top.location.href=\""
	                  + returnUrl
	                  + "\";" +
	                  "window.close();" +
	                  "}</script>");
		      return;
		}
		
		HomeDaoImpl homeDaoImpl = new HomeDaoImpl();
		List<Home> homes = homeDaoImpl.queryAllHomes();
		request.setAttribute("homes", homes);
		request.getRequestDispatcher("order.jsp").forward(request, response);
		return ;
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
