package com.leadersys;
/*
 *类名:ManageCondition.class
 *版本:1.0
 *日期:2020年12月29日
 */

import javax.swing.*;
import java.awt.*;

public class ManageCondition extends JPanel{

	FlowLayout flowlayout;
	JLabel  name;//名字 工号 性别 专业  年纪 薪水  
	JLabel  number;//名字 工号 性别 专业  年纪 薪水  
	JLabel  sex;//名字 工号 性别 专业  年纪 薪水  
	JLabel  profess;//名字 工号 性别 专业  年纪 薪水  
	JLabel  age;//名字 工号 性别 专业  年纪 薪水  
	JLabel  salary;//名字 工号 性别 专业  年纪 薪水  
	static JTextField nameT;
	static JTextField numberT;
	static JTextField sexT;
	static JTextField professT;
	static JTextField ageT;
	static JTextField salaryT;
	public ManageCondition() {
		flowlayout=new FlowLayout();
		setLayout(flowlayout);
		this.setBounds(0,107,516,110);//设置大小
		name =new JLabel("姓名");
		number =new JLabel("工号");
		sex =new JLabel("性别");
		profess =new JLabel("专业");
		age =new JLabel("年龄");
		salary =new JLabel("工资");
		nameT =new JTextField(19);
		numberT =new JTextField(19);
		sexT =new JTextField(19);
		professT =new JTextField(19);
		ageT =new JTextField(19);
		salaryT =new JTextField(19);
		this.add(name);
		this.add(nameT);
		this.add(number );
		this.add(numberT );
		this.add(sex);
		this.add(sexT);
		this.add(profess);
		this.add(professT);
		this.add(age);
		this.add(ageT);
		this.add(salary);
		this.add(salaryT);
		setBorder(BorderFactory.createTitledBorder("信息处理界面"));
	}
	static String readNameText() {	//读取 姓名 
		String nametext=nameT.getText();//此处需要写五个方法 来读取 文本信息
		return nametext;
	}
	static String readNumberText() {//读取 工号
		String nametext=numberT.getText();
		return nametext;
	}
	static String readSexTText() {//读取 性别
			String nametext=sexT.getText();
			return nametext;
		}
	static String readProfessTText() {	//读取 专业
			String nametext=professT.getText();
			return nametext;
		}
	static String readAgeTText() {	//读取 年纪
			String nametext=ageT.getText();
			return nametext;
			}
	static String readSalaryTText() {	//读取 薪资
				String nametext=salaryT.getText();
				return nametext;
			}
}
