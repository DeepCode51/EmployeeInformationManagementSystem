package com.leadersys;
/*
 *类名:ResetEvent.class
 *版本:1.0
 *日期:2020年12月29日
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetEvent implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		//将所有重置 文本
		ManageCondition.nameT.setText("");
		ManageCondition.numberT.setText("");
		ManageCondition.sexT.setText("");
		ManageCondition.salaryT.setText("");
		ManageCondition.professT.setText("");
		ManageCondition.ageT.setText("");
	}
}
