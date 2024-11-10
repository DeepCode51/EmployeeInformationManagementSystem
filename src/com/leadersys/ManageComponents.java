package com.leadersys;
/*
 *类名:ManageComponents.class
 *版本:1.0
 *日期:2020年12月29日
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ManageComponents extends JPanel {
	FlowLayout flowlayout;
	JButton addDate,delDate,chekDate,showDate,revData;// 增  删  改  查  重置 五个按钮
	JLabel  headname; //头 标题
	static JTextField headNumber;//头文本
	ActionListener Addlistener;
	ActionListener dellistener;
	ActionListener Updalistener;
	ActionListener Showlistener;
	ActionListener revListener;
	public ManageComponents() {
		flowlayout=new FlowLayout(FlowLayout.LEFT);
		setLayout(flowlayout);//
		headname=new JLabel("工号");
		headNumber =new JTextField(9);
		this.setBounds(0,52,516,57);//设置大小
		addDate =new JButton("增加");
		delDate =new JButton("删除");
		chekDate =new JButton("修改");
		showDate =new JButton("查找");
		revData =new JButton("重置");
		addEvent();//监听
		this.add(addDate);
		this.add(delDate);
		this.add(chekDate);
		this.add(showDate);
		this.add(revData);
		this.add(headname);
		this.add(headNumber);
		setBorder(BorderFactory.createTitledBorder("基本功能界面"));
	}
	void addEvent() {
		Addlistener =new AddEvent();//增加数据监听
		dellistener =new DelEvent();//删除数据监听
		Updalistener =new ChangeEvent();//更改数据监听
		Showlistener=new ShowEvent();//查找数据监听
		revListener=new ResetEvent();//重置监听
		addDate.addActionListener(Addlistener);
		delDate.addActionListener(dellistener);
		chekDate.addActionListener(Updalistener);
		showDate.addActionListener(Showlistener);
		revData.addActionListener(revListener);
	}
	static String readNumberText() {
		String nametext=headNumber.getText();
		return nametext;
	}

}
