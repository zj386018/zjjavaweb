package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.baiyi.hotelsystem.bean.Home;
import com.baiyi.hotelsystem.dao.HomeDaoImpl;

public class ManageFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		 if (!(request instanceof HttpServletRequest)
			        || !(response instanceof HttpServletResponse)) {
			      throw new ServletException(
			          "OncePerRequestFilter just supports HTTP requests");
			    }
			    // 获得在下面代码中要用的request,response,session对象
			    HttpServletRequest httpRequest = (HttpServletRequest) request;
			    HttpServletResponse httpResponse = (HttpServletResponse) response;
			    HttpSession session = httpRequest.getSession(true);
			    
			    
			    // 从session中获取用户信息
			    String loginInfo = (String) session.getAttribute("admname");
			    if (!(null == loginInfo || "".equals(loginInfo))) {
			      // 用户存在,可以访问此地址
			    	HomeDaoImpl homeDaoImpl = new HomeDaoImpl();
					List<Home> homes = homeDaoImpl.queryAllHomes();
					request.setAttribute("homes", homes);
			      chain.doFilter(request, response);
			    } else {
			      // 用户不存在,跳转回登录页面
			      String returnUrl = httpRequest.getContextPath() + "/adminLog.jsp";
			      httpRequest.setCharacterEncoding("UTF-8");
			      httpResponse.setContentType("text/html; charset=UTF-8"); // 转码
			      httpResponse
			          .getWriter()
			          .println(
			              "<script language=\"javascript\">alert(\"您还没有登录，请先登录!\");" +
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
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
