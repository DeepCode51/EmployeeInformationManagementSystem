package com.leadersys;
/*
 *类名:RegSuccessEvent.class
 *版本:1.0
 *日期:2020年12月29日
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RegSuccessEvent implements ActionListener {


	java.sql.PreparedStatement sqll;
	ResultSet rs;
	public void actionPerformed(ActionEvent e) {
		String CountText = RegSuccess.readCountTextDate();
		String PasswordText =RegSuccess.readPasswordTextDate();	//获取到注册的账号和密码
		String Uri="insert into user values(?,?)";
		boolean x=(CountText.equals(""));
		boolean y=(PasswordText.equals(""));
		boolean z=(x&&y);
		if (z==true) {
			
			JOptionPane.showMessageDialog(null, "账号和密码都不能为空", "账号注册消息",JOptionPane.WARNING_MESSAGE);
		}else if(y==true) {
			JOptionPane.showMessageDialog(null, "密码不能为空", "账号注册消息",JOptionPane.WARNING_MESSAGE);
		}else if(x==true) {
			JOptionPane.showMessageDialog(null, "账号不能为空", "账号注册消息",JOptionPane.WARNING_MESSAGE);
		}else 
		try {
			//执行查找
			//mysql_data.sql.executeUpdate(Uri);
			sqll = ManageDatabaseReading.con.prepareStatement(Uri);
			sqll.setString(1, CountText);
			sqll.setString(2, PasswordText);
			int ok=sqll.executeUpdate();
			JOptionPane.showMessageDialog(null, "注册成功", "账号注册消息",JOptionPane.WARNING_MESSAGE);
		}catch(SQLException e2){
			JOptionPane.showMessageDialog(null, "注册失败该账号已经存在", "账号注册消息",JOptionPane.WARNING_MESSAGE);
		}
	}
}
