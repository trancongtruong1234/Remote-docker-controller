package vn.cloud.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcraft.jsch.JSchException;

import vn.cloud.config.Config;
import vn.cloud.dao.HomeDao;
import vn.cloud.model.LoginModel;

@WebServlet(urlPatterns = {"/addserver"})
public class AddServerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/htm");
//		resp.setCharacterEncoding("UTF-8");
//		req.setCharacterEncoding("UTF-8");
//		HttpSession session = req.getSession();
//		LoginModel info = (LoginModel) session.getAttribute("info");
//		if(info.getRole() == 0)
//		{
//			RequestDispatcher rq = req.getRequestDispatcher("/views/create.jsp");
//			rq.forward(req, resp);
//		}
//		else
//		{
//			resp.sendRedirect("page404");
//		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
//		String os = req.getParameter("os");
//		String ram  = req.getParameter("ram");
//		String cpu = req.getParameter("cpu");
		HomeDao hd = new HomeDao();
//		HttpSession session = req.getSession();
//		LoginModel info = (LoginModel) session.getAttribute("info");
		String ip_server = req.getParameter("ip_server");
		hd.insertServer(ip_server);
		//resp.sendRedirect("home");
		RequestDispatcher rq = req.getRequestDispatcher("/views/addserver.jsp");
		rq.forward(req, resp);
	}

}
