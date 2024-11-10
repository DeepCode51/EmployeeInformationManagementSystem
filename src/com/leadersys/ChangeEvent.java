package com.leadersys;
/*
 *类名:ChangeEvent.class
 *版本:1.0
 *日期:2020年12月29日
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class ChangeEvent  implements ActionListener {
	Connection con=null;
	java.sql.PreparedStatement sqll;
	String name;
	String number;
	String sex;
	String sale;
	String pro;
	String ageLL;
	String headnumber;
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//需要将 6个文本框的 数据全部读取出来   
		name=ManageCondition.readNameText();
		number=ManageCondition.readNumberText();
		sex=ManageCondition.readSexTText();
		sale=ManageCondition.readSalaryTText();
		pro=ManageCondition.readProfessTText();
		ageLL=ManageCondition.readAgeTText();
		headnumber =ManageComponents.readNumberText();
		//名字不能为空  如果为空报错
		boolean x=(headnumber.equals(""));
		if(x==true) {
			JOptionPane.showMessageDialog(null, "工号条件不能为空", "消息",JOptionPane.WARNING_MESSAGE);
		}else {
			addData();
		}
	}
	void addData() {
		String Uri="update leaderdate set 工号=?,姓名=?,性别=?,薪水=?,专业=?,年龄=? where 工号=?";
		try {
			sqll = ManageDatabaseReading.con.prepareStatement(Uri);
			sqll.setString(1, number);
			sqll.setString(2, name);
			sqll.setString(3, sex);
			sqll.setString(4, sale);
			sqll.setString(5, pro);
			sqll.setString(6, ageLL);
			sqll.setString(7, headnumber);
			int ok=sqll.executeUpdate();
			JOptionPane.showMessageDialog(null, "更改成功", "消息",JOptionPane.WARNING_MESSAGE);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "工号条件不能为空", "消息",JOptionPane.WARNING_MESSAGE);
		}
	}
}
