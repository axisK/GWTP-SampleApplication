package com.a24studio.gwt.sampleapplication.client.dispatch.handler;

import com.a24studio.gwt.sampleapplication.client.model.User;
import com.gwtplatform.dispatch.shared.Result;

public class LoginResult implements Result {
	private User user = null;

	public LoginResult( User user ) {
		this.user = user;
	}

	public User getUser( ) {
		return this.user;
	}
}
