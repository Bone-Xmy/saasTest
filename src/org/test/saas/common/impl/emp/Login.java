package org.test.saas.common.impl.emp;

import org.test.saas.common.*;

public class Login implements BaseInterface{
	private String userName;
	private String password;
	private String host;

	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getUserName(){
		return this.userName;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
	public void setHost(String name){
		this.host = host;
	}
	public String getHost(){
		return this.host;
	}

	public String[] doing(){
		String url = getHost() + "/saas/emp/Login.ajax";
		
		
	}
}