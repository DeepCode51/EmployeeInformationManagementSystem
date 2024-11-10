package com.leadersys;
/*
 *类名:ManageBackgroundPictures.class
 *版本:1.0
 *日期:2020年12月29日
 */

import javax.swing.*;
import java.awt.*;

public class ManageBackgroundPictures extends JPanel {
	FlowLayout flowlayout;
	JLabel img1;//名字 工号 性别 专业  年纪 薪水  图片
	public ManageBackgroundPictures() {
		setLayout(null);//
		ImageIcon img = new ImageIcon("src/img/2.jpg");//这是背景图片 
		img1=new JLabel(img);
		img1.setBounds(0,0,530, 50);//设置背景图片 设置背景位置
		this.setBounds(0,0,530,50);
		add(img1);
	}

}
