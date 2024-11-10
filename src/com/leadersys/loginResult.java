package com.leadersys;
/*
 *类名:loginResult.class
 *版本:1.0
 *日期:2020年12月29日
 */
import javax.swing.*;
import java.awt.*;

public class loginResult extends JFrame{
	
	ManageBackgroundPictures apan;//第一类布局
	ManageComponents bpan;//第二类布局
	ManageCondition cpan;//第三类布局
	ManageForm dpan;//第四类布局  //负责装 增  删  改  查  重置 五个按钮  用flowLayou 布局  	第一个用来装一个图片
	static final int WIDTH=530;//设置顶层框架的宽度
	static final int HEIGHT=450;//设置顶层框架的高度
	//声明  5个按钮  6个标签   6个编辑框  一个表格  一个标签图片
	JRadioButton man,woman;//单选按钮 男 女 
	ButtonGroup group;//用来放上面的按钮 
	public loginResult(){
		setVisible(true); 
		init();
		setResizable(false);//不可变窗口
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		validate();
	}
	void init() {//设置当前窗口位置
		Toolkit kit =Toolkit.getDefaultToolkit();//获取对象大小
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;//获取屏幕高度和宽度
		int x=(width-WIDTH)/2;
		int y=(height-HEIGHT)/2;
		setSize(WIDTH,HEIGHT);
		setLocation(x, y);//设置位置 和窗口大小
		this.setLayout(null);//第一步让当前布局为空
		apan=new ManageBackgroundPictures();//第一类放在 图片
		bpan=new ManageComponents();//第二类放按钮
		cpan=new ManageCondition();//放信息框
		dpan=new ManageForm();//放表格
		this.add(apan);
		this.add(bpan);
		this.add(cpan);
		this.add(dpan);
	
	}
}
