package com.a24studio.gwt.sampleapplication.client.dispatch.handler;

import com.gwtplatform.dispatch.shared.ActionImpl;

public class LoginAction extends ActionImpl<LoginResult>{
	private String username;
	private String password;
	
	public LoginAction( final String username, final String password ) {
		this.username = username;
		this.password = password;
	}
	
	public String getUsername( ) {
		return this.username;
	}
	
	public String getPassword( ) {
		return this.password;
	}
}
