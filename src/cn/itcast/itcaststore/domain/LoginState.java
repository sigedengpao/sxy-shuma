package cn.itcast.itcaststore.domain;

import java.io.Serializable;
import java.util.Date;
public class LoginState implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id; // 用户编号
	private Date loginTime;//登录时间
	private Date logoutTime;//退出时间
	
	public Date getLoginTime() {
		loginTime = new Date();
		return loginTime;
	}
	
//	public void setLoginTime(Date loginTime) {
//		this.loginTime = loginTime;
//	}

	public Date getLogoutTime() {
		logoutTime = new Date();
		return logoutTime;
	}
	/*
	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}*/
}
