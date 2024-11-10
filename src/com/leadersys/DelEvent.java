package com.leadersys;
/*
 *类名:DelEvent.class
 *版本:1.0
 *日期:2020年12月29日
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class DelEvent  implements ActionListener {
	Connection con=null;
	java.sql.Statement sql;
	java.sql.PreparedStatement sqll;
	String headnumber;
	public void actionPerformed(ActionEvent e) {
		headnumber =ManageComponents.readNumberText();
		//名字不能为空  如果为空报错
		boolean x=(headnumber.equals(""));
		if(x==true) {
			JOptionPane.showMessageDialog(null, "条件工号不能为空", "消息",JOptionPane.WARNING_MESSAGE);
		}else {
			delDate();
		}
	}
	void delDate() {
		String Uri="delete from leaderdate where 工号=?";
		try {
			sqll = ManageDatabaseReading.con.prepareStatement(Uri);
			sqll.setString(1,headnumber);
			int ok=sqll.executeUpdate();
			if(ok==0) {
				JOptionPane.showMessageDialog(null, "未找到相关工号", "消息",JOptionPane.WARNING_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(null, "删除成功", "消息",JOptionPane.WARNING_MESSAGE);
			}
		}catch(SQLException e) {
		}
	}
}
