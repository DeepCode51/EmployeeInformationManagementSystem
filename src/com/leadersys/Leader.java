package com.leadersys;
/*
 *类名:Leader.class
 *版本:1.0
 *日期:2020年12月29日
 */
public class Leader {
		static Login login;
		public static void setDisappear(Login logina) {
			login=logina;
	}
		public static void disappear() {
			login.dispose();
	}
	public static void main(String[] args) {
		Login login =new Login();//加载登录类
		setDisappear(login);
	}
}
