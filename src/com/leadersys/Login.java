package com.leadersys;
/*
 *类名:Login.class
 *版本:1.0
 *日期:2020年12月29日
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Login extends JFrame{
	static JPanel contentPanel;//定义一个面板
	static final int WIDTH=390;//设置顶层框架的宽度
	static final int HEIGHT=245;//设置顶层框架的高度
	JButton ok;//登录按钮
	JLabel reg;//注册按钮
	JLabel title;//标题
	JLabel name;//用户名 标签
	JLabel password;//密码  标签
	static JTextField nameinput;//用户输入框
	static JPasswordField passwordinput;//密码输入框
	JLabel img1;
	//定义监视器
	ActionListener loginlistener;//登录监视声明
	RegEvent reglistener;//注册监视声明
	public Login(){
		
		setVisible(true); 
		init();
		mysqld();
		setResizable(false);//不可变窗口
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		validate();
	}
	void init(){
		contentPanel =new JPanel();
		contentPanel.setLayout(null);//设置布局为空
		ok=new JButton("安全登录");//定义按钮
		reg=new JLabel("注册账号");
		title =new JLabel("员工信息管理系统");
		name =new JLabel("账号");
		password =new JLabel("密码");
		nameinput=new JTextField(15);//账号
		passwordinput=new JPasswordField(15);//密码框
		ImageIcon img = new ImageIcon("src/img/1.jpg");//这是背景图片 
		img1=new JLabel(img);
		img1.setBounds(0,0,img.getIconWidth(), img.getIconHeight());//设置背景图片 设置背景位置
		Toolkit kit =Toolkit.getDefaultToolkit();//获取对象大小	//设置窗口位置
		Dimension screenSize=kit.getScreenSize();
		int width=screenSize.width;
		int height=screenSize.height;//获取屏幕高度和宽度
		int x=(width-WIDTH)/2;
		int y=(height-HEIGHT)/2;
		setSize(WIDTH,HEIGHT);
		setLocation(x, y);//设置位置 和窗口大小	以上设置背景设置标题 
		Font f=new Font("宋体",Font.BOLD,26);//标题
		Font fe=new Font("华文bai行楷",Font.BOLD,16);//标签
		Font fee=new Font("宋体",Font.PLAIN,16);//账号框
		Font feee=new Font("宋体",Font.BOLD,16);//登录按钮
		Font a=new Font("宋体",Font.BOLD,11);//注册标签
		title.setForeground(Color.WHITE);
		title.setFont(f);
		title.setBounds(80, 30, 300, 54);
		name.setForeground(Color.cyan);//加入标签 用户名和 密码
		name.setBounds(80, 90, 62, 25);
		name.setFont(fe);
		password.setForeground(Color.cyan);
		password.setBounds(80, 123, 62, 25);
		password.setFont(fe);
		nameinput.setForeground(Color.BLACK);//加入账号密码 的输入框
		nameinput.setBounds(120, 92, 180, 23);
		nameinput.setFont(fee);
		passwordinput.setForeground(Color.BLACK);
		passwordinput.setBounds(120, 125, 180, 23);
		passwordinput.setFont(fee);
		ok.setForeground(Color.white);	//加入 登录按钮
		ok.setBackground(new Color(8,189,252));
		ok.setBounds(80, 160, 220, 33);
		ok.setFont(feee);
		reg.setForeground(new Color(166,166,166));//加入注册标签
		reg.setBounds(10, 180, 50, 20);
		reg.setFont(a);
		contentPanel.add(reg);
		contentPanel.add(ok);
		contentPanel.add(passwordinput);
		contentPanel.add(nameinput);
		contentPanel.add(password);
		contentPanel.add(name);
		contentPanel.add(title);
		contentPanel.add(img1);
		add(contentPanel);
	}
	//读取账号框数据
	static String readCountTextDate() {
		//mysql_data mysqlCon=new mysql_data();//将必要的mysql 读取出来 
		String nametext=nameinput.getText();
		return nametext;
	}
	//读取密码框数据
	static String  readPasswordTextDate() {
		String passwordtext=new String(passwordinput.getPassword());
		String str =new String(passwordtext);
		return str;
	}
	//进行读取数据库内容
	void mysqld() {
		ManageDatabaseReading mysql=new ManageDatabaseReading();//实现了取 sql 内容
		loginlistener =new LoginEvent();//创建登录监视器
		ok.addActionListener(loginlistener);
		reglistener =new RegEvent();//创建注册监视器
		reg.addMouseListener(reglistener);
	}
}
