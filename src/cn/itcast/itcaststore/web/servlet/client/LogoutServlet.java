package cn.itcast.itcaststore.web.servlet.client;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.itcaststore.dao.LoginStateDao;
import cn.itcast.itcaststore.domain.LoginState;
import cn.itcast.itcaststore.domain.User;

public class LogoutServlet extends HttpServlet {

	private LoginStateDao loginstatedao = new LoginStateDao();
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取session对象.
		User user = (User) request.getSession().getAttribute("user");
		//LoginState loginstate = (LoginState) request.getSession().getAttribute("loginstate");
		int login_userid = user.getId();
		LoginState loginstate = new LoginState();
		try {
			loginstatedao.addLogout(loginstate, login_userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		// 销毁session
		session.invalidate();
		// flag标识
		String flag = request.getParameter("flag");
		if (flag == null || flag.trim().isEmpty()) {
			// 重定向到首页
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
	}
}