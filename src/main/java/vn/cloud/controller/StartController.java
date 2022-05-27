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
		
		ArrayList<ServerModel> listserver = (ArrayList<ServerModel>) session.getAttribute("listserver");
		
		// lấy ip theo id
		int _id_server=Integer.parseInt(server);	
		ec2ip = hd.getIp(_id_server);
		
//		ArrayList<ServerModel> listserver = new ArrayList<ServerModel>();
//		try {
//			HomeDao homeDao = new HomeDao();
//			listserver = (ArrayList<ServerModel>) homeDao.getListServer();
//		}
//		catch (Exception e) {
//			System.out.println(e);
//		}
//		
//		int _id_server=Integer.parseInt(server);		
//		for (ServerModel _server  : listserver) {
//			  int id_server=_server.getId_server();
//			  //String _id_server =_String.valueOf(id_server);
//		      if(id_server==_id_server) {
//		    	  String ip_server=_server.getIp_server();
//		    	  ec2ip=ip_server;
//		    	  System.out.println(id_server);
//		    	  System.out.println(_id_server);
//		    	  System.out.println(ec2ip);
//		    	  break;
//		      }
//		    }

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
