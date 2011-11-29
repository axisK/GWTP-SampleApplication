package com.a24studio.gwt.sampleapplication.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.a24studio.gwt.sampleapplication.client.presenter.LoginPresenter;
import com.a24studio.gwt.sampleapplication.client.view.LoginView;

public class PresentersModule extends AbstractPresenterModule {

	/**
	 * Configures the module's bindings.
	 */
	@Override
	protected void configure( ) {
		bindPresenter( LoginPresenter.class, LoginPresenter.MyView.class, LoginView.class, LoginPresenter.MyProxy.class );
	}
}
