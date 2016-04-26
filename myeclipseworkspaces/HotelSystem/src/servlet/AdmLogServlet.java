package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baiyi.hotelsystem.bean.Home;
import com.baiyi.hotelsystem.bean.Worker;
import com.baiyi.hotelsystem.dao.HomeDaoImpl;
import com.baiyi.hotelsystem.dao.WorkerDaoImpl;


public class AdmLogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AdmLogServlet() {
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

		//获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//这里用数据库检索是否存在
		WorkerDaoImpl workerDaoImpl = new WorkerDaoImpl();
		Worker worker = workerDaoImpl.querySingleWorker(username, password);
		if (worker!=null){
			HomeDaoImpl homeDaoImpl = new HomeDaoImpl();
			List<Home> homes = homeDaoImpl.queryAllHomes();
			request.setAttribute("homes", homes);
			request.getSession().setAttribute("admname", username);
			request.getRequestDispatcher("manage.jsp").forward(request, response);
			return ;
		}
		else{
		request.setAttribute("loginState", "false");
		request.getRequestDispatcher("adminLog.jsp").forward(request, response);
		}
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
