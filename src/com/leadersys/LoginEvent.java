package com.leadersys;
/*
 *类名:LoginEvent.class
 *版本:1.0
 *日期:2020年12月29日
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginEvent implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String CountText = Login.readCountTextDate();
		String PasswordText = Login.readPasswordTextDate();
		ResultSet rs;
		boolean bo=false;
		boolean b1=loginRead(CountText,PasswordText);
		if(b1==true) {
		 try{
				
				rs=ManageDatabaseReading.sql.executeQuery("select * from user ");
				while (rs.next()) {
					String count=rs.getString(1);
					String password=rs.getString(2);
					
			
						boolean x=(count.equals(CountText));
						boolean y=(PasswordText.equals(password));
						boolean z=(x&&y);
						if(z==true) {
							bo=true;//成功读取所有账
						}
				}
				if (bo==true) {
					
					Leader.disappear();
					loginResult loginresult =new loginResult();
					//此处写登录后的类
				}else {
					JOptionPane.showMessageDialog(null, "账号或密码错误", "账号信息",JOptionPane.WARNING_MESSAGE);
				}
			}catch(SQLException e1){
			}
		} 
	}
		boolean loginRead(String CountText,String PasswordText) {
		boolean x=(CountText.equals(""));
		boolean y=(PasswordText.equals(""));
		boolean z=(x&&y);
		if (z==true) {
			JOptionPane.showMessageDialog(null, "账号和密码都不能为空", "账号注册消息",JOptionPane.WARNING_MESSAGE);
			return false;
		}else if(y==true) {
			JOptionPane.showMessageDialog(null, "密码不能为空", "账号注册消息",JOptionPane.WARNING_MESSAGE);
			return false;
		}else if(x==true) {
			JOptionPane.showMessageDialog(null, "账号不能为空", "账号注册消息",JOptionPane.WARNING_MESSAGE);
			return false;
		}else {
			return true ;
		}
	}
}
