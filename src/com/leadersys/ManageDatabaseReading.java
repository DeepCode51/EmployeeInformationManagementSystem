package com.leadersys;
/*
 *类名:ManageDatabaseReading.class
 *版本:1.0
 *日期:2020年12月29日
 */
import java.sql.*;

public class ManageDatabaseReading {
	static Connection con=null;
	static Statement sql;
	ResultSet rs;

	 ManageDatabaseReading(){
		//加载驱动
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e){
		}
		//连接数据库
		String uri="jdbc:mysql://localhost:3306/graduation_205_datasystemcon?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&AllowPublicKeyRetrieval=True";
		try{

			con=DriverManager.getConnection(uri,"root","123456");//账号密码
			sql=con.createStatement();
			System.out.println("链接数据库成功");
		}catch(SQLException e){
			System.out.println("链接数据库失败");
			String temp=e.getMessage();
			System.out.println(temp);
			String[] arr1=temp.split(" ");
			if(arr1[0].equals("Unknown")) {
			System.out.println("请建立名字为："+arr1[2]+"数据库");
			}
			if(arr1[0].equals("Access")) {
			System.out.println("请检查数据库密码是否正确：数据库密码错误");
			}
		}
	}
}
