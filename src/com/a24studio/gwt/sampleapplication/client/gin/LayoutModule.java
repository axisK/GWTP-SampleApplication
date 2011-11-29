package com.a24studio.gwt.sampleapplication.client.gin;

import com.a24studio.gwt.sampleapplication.client.place.ClientPlaceManager;
import com.a24studio.gwt.sampleapplication.client.place.DefaultErrorPlace;
import com.a24studio.gwt.sampleapplication.client.place.DefaultPlace;
import com.a24studio.gwt.sampleapplication.client.place.NameTokens;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.a24studio.gwt.sampleapplication.client.presenter.ApplicationPresenter;
import com.a24studio.gwt.sampleapplication.client.view.ApplicationView;

/**
 * Module configuration for the layout section of the application.
 * The layout section also takes the place of the main module.
 * 
 * @author Petrus Rademeyer
 * @since 29 November 2011
 */
public class LayoutModule extends AbstractPresenterModule {

	/**
	 * Configures the module's bindings.
	 */
	@Override
	protected void configure() {
		install( new DefaultModule( ClientPlaceManager.class ) );

		bindConstant( ).annotatedWith( DefaultPlace.class ).to( NameTokens.login );
		bindConstant( ).annotatedWith( DefaultErrorPlace.class ).to( NameTokens.login );
		bindPresenter( ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class, ApplicationPresenter.MyProxy.class );
	}
}
