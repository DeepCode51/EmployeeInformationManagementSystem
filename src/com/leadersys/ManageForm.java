package com.leadersys;
/*
 *类名:ManageForm.class
 *版本:1.0
 *日期:2020年12月29日
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.Vector;

public class ManageForm extends JPanel{
	static JTable table=null;	
	static Vector rwo;
	JScrollPane jscrollpane;
	Object columns[] ={"工号","姓名","性别","薪水","专业","年龄"};//标题信息
	static Object a[][];//标题信息
	static int row ;
	static DefaultTableModel  model;
	static TableColumnModel columnModel;
	public ManageForm (){
		JTable tableL=getTable();
		JScrollPane jscrollpane=new JScrollPane(tableL);
		jscrollpane.setPreferredSize(new Dimension(500,160));
		tableL.setPreferredSize(new Dimension(200,160));
		jscrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setBounds(0, 215,516,190);
		setBorder(BorderFactory.createTitledBorder("数据显示界面"));
		add(jscrollpane);
	}

	JTable getTable() {
		if(table==null) {
			table=new JTable();//创建 
			int[] columnWidth={70,70,70,70,70,70};//设置列宽
			model=new DefaultTableModel(){
				public boolean isCellEditable(int row, int column)
				{
				return false;
				}
				};//列宽 和行数  并且让表格不可编辑
			model.setColumnIdentifiers(columns);
			table.setModel(model);//设置为表格的模式
			columnModel=table.getColumnModel();//获取到表格的控制
			table.getTableHeader().setReorderingAllowed(false);//让表格不可拖动
			table.getTableHeader().setResizingAllowed(false);//让表格不可拖动
			int count=columnModel.getColumnCount();//返回列数和行数
			for(int i=0;i<count;i++){
				javax.swing.table.TableColumn column=columnModel.getColumn(i);//返回列表中的对象
				column.setPreferredWidth(columnWidth[i]);
			}
			 rwo = new Vector(6);
		}
		return table;
	}
}

