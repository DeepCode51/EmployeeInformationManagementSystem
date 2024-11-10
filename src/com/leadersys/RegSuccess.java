package com.leadersys;
/*
 *类名:RegSuccess.class
 *版本:1.0
 *日期:2020年12月29日
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegSuccess extends JFrame{
	static JPanel Apanel;//定义一个面板
	static final int WIDTH=421;//设置顶层框架的宽度
	static final int HEIGHT=260;//设置顶层框架的高度
	//三个标签
	JLabel regcount;//注册账号
	JLabel regpassword;//注册密码
	//一个文本框  两个密码框
	static JTextField nameinput;//用户输入框
	static JPasswordField passwordinput;//密码输入框
	//一个注册按钮
	JButton regok;//登录按钮
	//一个标题标签
	JLabel title;//标题
	//一个背景
	JLabel img1;//用户名 标签
	ActionListener reglistener;//注册监视声明
	public RegSuccess(){
		setVisible(true); 
		init();
		regCount();
		setResizable(false);//不可变窗口
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		validate();
	}
	void init() {//初始化注册窗口
		Apanel =new JPanel();
		Apanel .setLayout(null);//设置布局为空
		//设置字体形式
		Font f=new Font("宋体",Font.BOLD,30);//标题
		Font fe=new Font("华文bai行楷",Font.PLAIN,20);//标签
		Font fee=new Font("宋体",Font.PLAIN,16);//账号框
		Font feee=new Font("宋体",Font.BOLD,16);//登录按钮
		//让他显示的位置在中间
		Toolkit kit =Toolkit.getDefaultToolkit();//获取对象大小
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;//获取屏幕高度和宽度
		int x=(width-WIDTH)/2;
		int y=(height-HEIGHT)/2;
		setSize(WIDTH,HEIGHT);
		setLocation(x-100, y-100);//设置位置 和窗口大小
		//设置背景颜色
		ImageIcon img = new ImageIcon("src/img/1.jpg");//这是背景图片 
		title=new JLabel("领导管理系统账号注册");//标题
		regcount =new JLabel("账号");//注册账号
		regpassword=new JLabel("密码");//注册密码
		nameinput=new JTextField();//用户输入框
		passwordinput=new JPasswordField();;//密码输入框
		regok=new JButton ("立即注册");
		img1=new JLabel(img);
		img1.setBounds(0,0,421, 120);//设置背景图片 设置背景位置
		title.setForeground(Color.WHITE);	//加载标题
		title.setBounds(40, 45, 400, 30);
		title.setFont(f);
		regcount.setForeground(Color.black);		//添加标签
		regcount.setBounds(70, 125, 300, 25);
		regcount.setFont(fe);
		regpassword.setForeground(Color.black);
		regpassword.setBounds(70, 155, 300, 25);
		regpassword.setFont(fe);
		nameinput.setForeground(Color.black);
		nameinput.setBounds(120, 125, 210, 25);
		nameinput.setFont(fee);
		passwordinput.setForeground(Color.black);
		passwordinput.setBounds(120, 155, 210, 25);
		passwordinput.setFont(fee);
		regok.setForeground(Color.white);
		regok.setBackground(new Color(8,189,252));
		regok.setBounds(70, 185, 260, 30);
		regok.setFont(feee);
		Apanel.add(regok);
		Apanel.add(passwordinput);
		Apanel.add(nameinput);
		Apanel.add(regpassword);
		Apanel.add(regcount);
		Apanel.add(title);
		Apanel.add(img1);
		add(Apanel);
	}
	static String readCountTextDate() {//获取注册的账号和密码
		//mysql_data mysqlCon=new mysql_data();//将必要的mysql 读取出来 
		String nametext=nameinput.getText();
		return nametext;
	}
	static String  readPasswordTextDate() {	//读取密码框数据
		String passwordtext=new String(passwordinput.getPassword());
		String str =new String(passwordtext);
		return str;
	}
	void regCount() {
		reglistener=new RegSuccessEvent();
		regok.addActionListener(reglistener);
	}

}
