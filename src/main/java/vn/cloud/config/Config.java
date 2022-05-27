package vn.cloud.config;

public class Config {
	public static  String ipServer1 = "54.224.114.96"; // thay đổi ip bằng ip public trên ec2 chứa database
	public static String ipServer2 = "34.228.89.203"; // thay đổi ip bằng ip public ec2 thứ 2
	public static String ipServer3 = "3.217.238.6"; // thay đôi ip bằng ip public ec2 thứ 3
	public static String userSql = "SA"; // thay đổi tài khoản đăng nhập sql container
	public static String pasSql = "truong123"; // thay đổi mật khẩu đăng nhập sql container
	public static String privatekeyPath = "C:\\Users\\tranc\\cloud\\ubuntu\\ubuntu.pem"; // thay đổi path của key ec2
	//public static String privatekeyPath = "/usr/local/tomcat/webapps/ubuntu.pem";
	public static String databaseName = "usercloud";
	
	public static String ipServer4 = "172.31.91.248"; // thay đôi ip bằng ip public ec2 thứ 3
}
