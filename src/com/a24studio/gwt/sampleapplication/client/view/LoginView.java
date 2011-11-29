package com.a24studio.gwt.sampleapplication.client.view;

import com.a24studio.gwt.sampleapplication.client.presenter.LoginPresenter;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * Login page.
 * 
 * @author Petrus Rademeyer
 * @since 29 November 2011
 */
public class LoginView extends ViewImpl implements LoginPresenter.MyView {

	private final Widget widget;

	@UiField TextBox usernameBox;
	@UiField TextBox passwordBox;
	@UiField Button loginButton;
	
	public interface Binder extends UiBinder<Widget, LoginView> {
	}

	@Inject
	public LoginView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public Button getLoginButton() {
		return loginButton;
	}

	@Override
	public TextBox getUsernameBox() {
		return usernameBox;
	}

	@Override
	public TextBox getPasswordBox() {
		return passwordBox;
	}
}
