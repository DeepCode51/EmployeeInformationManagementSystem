package com.leadersys;
/*
 *类名:ShowEvent.class
 *版本:1.0
 *日期:2020年12月29日
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowEvent  implements ActionListener {
	Connection con=null;
	boolean rks=true;
	java.sql.PreparedStatement sqll;
	ResultSet rs;
	int a=0;
	boolean real=true;
	String name,number,sex,sale,pro,ageLL,headnumber;
	public void actionPerformed(ActionEvent e) {
		headnumber =ManageComponents.readNumberText();//条件工号
		//条件工号 不能为空  如果为空报错
		boolean x=(headnumber.equals(""));
		if(x==true) {
			showallDate();
		}else {
			showdate();
		}
	}
	void showdate() {
		int row,clon;
		int count=0;
		
		String  bol;
		String Uri="select * from  leaderdate where 工号=?";
		boolean ok=true;
		try {
			
			sqll = ManageDatabaseReading.con.prepareStatement(Uri);
			sqll.setString(1, headnumber);//查询条件
			rs=sqll.executeQuery();
			ManageForm.model.setNumRows(0);
				while(rs.next()) {	
					number=rs.getString(1);
					name=rs.getString(2);
					sex=rs.getString(3);
					sale=rs.getString(4);
					pro=rs.getString(5);
					ageLL=rs.getString(6);
					ManageForm.rwo.add(0,number);
					ManageForm.rwo.add(1,name);
					ManageForm.rwo.add(2,sex);
					ManageForm.rwo.add(3,sale);
					ManageForm.rwo.add(4,pro);
					ManageForm.rwo.add(5,ageLL);
					ManageForm.model.addRow(ManageForm.rwo);//向表格里面添加数据
					ManageCondition.nameT.setText(name);
					ManageCondition.numberT.setText(number);
					ManageCondition.sexT.setText(sex);
					ManageCondition.salaryT.setText(sale);
					ManageCondition.professT.setText(pro);
					ManageCondition.ageT.setText(ageLL);
					a++;
			}
				if(a!=0) {
					a=0;
					
				}else {
					ManageCondition.nameT.setText("");
					ManageCondition.numberT.setText("");
					ManageCondition.sexT.setText("");
					ManageCondition.salaryT.setText("");
					ManageCondition.professT.setText("");
					ManageCondition.ageT.setText("");
					JOptionPane.showMessageDialog(null, "当前工号已经不存在", "消息",JOptionPane.WARNING_MESSAGE);
				}
			//表明上面没有执行
			
		}catch(SQLException e) {
		}
	}
	void showallDate() {
		String [] dm=new String [6];
		String Uri="select * from  leaderdate";
	try {
			sqll = ManageDatabaseReading.con.prepareStatement(Uri);
			rs=sqll.executeQuery();
			ManageForm.model.setNumRows(0);
			while(rs.next()) {
					number=rs.getString(1);
					name=rs.getString(2);
					sex=rs.getString(3);
					sale=rs.getString(4);
					pro=rs.getString(5);
					ageLL=rs.getString(6);
					dm[0]=number;
					dm[1]=name;
					dm[2]=sex;
					dm[3]=sale;
					dm[4]=pro;
					dm[5]=ageLL;
					ManageForm.model.addRow(dm);
			}
		}catch(SQLException e) {
		}
	}
}
