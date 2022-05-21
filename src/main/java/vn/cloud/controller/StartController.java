package vn.cloud.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcraft.jsch.JSchException;

import vn.cloud.config.Config;
import vn.cloud.connection.DBconnect;
import vn.cloud.dao.HomeDao;
import vn.cloud.model.LoginModel;
import vn.cloud.model.ServerModel;

@WebServlet(urlPatterns = { "/startC" })
public class StartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HomeDao hd = new HomeDao();
		String cid = req.getParameter("cid");
		String cName = req.getParameter("name");
		System.out.println(cid);
		HttpSession session = req.getSession();
		LoginModel info = (LoginModel) session.getAttribute("info");
		String ec2ip ="";
		String server = req.getParameter("server");
		
		// Van code them 
		int _id_server=Integer.parseInt(server);
		
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
		try {
			hd.startContainer(cid,ec2ip);
			if(info.getRole() == 0)
			{
			Date nowdate = new Date();
			hd.setTime(nowdate, cName);
			}
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(info.getRole() == 0)
		{
		resp.sendRedirect("home?server="+ server);
		}
		else
		{
			resp.sendRedirect("admincontainer?server=" + server);
		}
	}
	

}
