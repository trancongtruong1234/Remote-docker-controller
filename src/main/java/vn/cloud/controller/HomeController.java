package vn.cloud.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcraft.jsch.JSchException;

import vn.cloud.config.CheckTime;
import vn.cloud.config.Config;
import vn.cloud.connection.DBconnect;
import vn.cloud.dao.HomeDao;
import vn.cloud.model.LoginModel;
import vn.cloud.model.ServerModel;
import vn.cloud.model.DetailModel;;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		LoginModel info = (LoginModel) session.getAttribute("info");
		String ec2ip ="";
		String server = req.getParameter("server");
		
		int _id_server=Integer.parseInt(server);
		//System.out.print(server);
		// Lấy thông tin của list server 
		
		
		String sql = "select * from servers;";
		ResultSet rst;
		ArrayList<ServerModel> listserver = new ArrayList<>();
		try {
			// kết nối sql
			Connection conn = new DBconnect().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			rst = ps.executeQuery();
			
		    while (rst.next()) {
		    	ServerModel server_ = new ServerModel(rst.getInt("id_server"), rst.getString("ip_server"));
		    	listserver.add(server_);
		    }
//		    for (int i = 0; i < listserver.size(); i++) {
//
//		        System.out.println(listserver.get(i));
//		        System.out.println(listserver.get(i));
//		    }
		} catch (Exception e) {

		}
		//req.setAttribute("listserver", listserver);
		
		//session.setAttribute("listserver", listserver);
		
		for (ServerModel _server  : listserver) {
			  int id_server=_server.getId_server();
			  //String _id_server =_String.valueOf(id_server);
		      if(id_server==_id_server) {
		    	  String ip_server=_server.getIp_server();
		    	  ec2ip=ip_server;
		    	  System.out.print(id_server);
		    	  System.out.print(_id_server);
		    	  System.out.print(ec2ip);
		    	  break;
		      }
		    }
		
		
//		if(server.equals("1"))
//		{
//			ec2ip = Config.ipServer1;
//		}
//		if(server.equals("2"))
//		{
//			ec2ip = Config.ipServer2;
//		}
//		if(server.equals("3"))
//		{
//			ec2ip = Config.ipServer3;
//		}
		if(info.getRole() == 0)
		{
			String name = "user" + Integer.toString(info.getId()) + "-";
			CheckTime check = new CheckTime();
			check.checkTimeContainner(name, ec2ip);
			  HomeDao p = new HomeDao(); 
			  List<DetailModel> newlist; 
			  try {
				newlist = p.getDetail(name, ec2ip);
				req.setAttribute("listC", newlist);
			} catch (JSchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			req.setAttribute("server",server);
			resp.setHeader("Refresh", "60");
			RequestDispatcher rq = req.getRequestDispatcher("/views/home.jsp");
			rq.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("page404");
		}
	}
}
