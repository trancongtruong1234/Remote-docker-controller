package vn.cloud.config;

public class Config {
	public static  String ipServer1 = "44.206.56.60"; // thay đổi ip bằng ip public trên ec2 chứa database
	public static String userSql = "SA"; // thay đổi tài khoản đăng nhập sql container
	public static String pasSql = "truong123"; // thay đổi mật khẩu đăng nhập sql container
	//public static String privatekeyPath = "C:\\Users\\tranc\\cloud\\newubuntu1.pem"; // thay đổi path của key ec2
	public static String privatekeyPath = "/usr/local/tomcat/webapps/newubuntu1.pem";
	public static String databaseName = "usercloud";
	
}
