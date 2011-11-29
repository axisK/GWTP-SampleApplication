package com.a24studio.gwt.sampleapplication.client.gin;

import com.a24studio.gwt.sampleapplication.client.place.ClientPlaceManager;
import com.a24studio.gwt.sampleapplication.client.place.DefaultPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

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
	}
}
