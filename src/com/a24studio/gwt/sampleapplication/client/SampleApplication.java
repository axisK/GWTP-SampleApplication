package com.a24studio.gwt.sampleapplication.client;

import com.a24studio.gwt.sampleapplication.client.gin.GInjector;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SampleApplication implements EntryPoint {

	public final GInjector ginjector = GWT.create( GInjector.class );
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		DelayedBindRegistry.bind( ginjector );
		ginjector.getPlaceManager( ).revealCurrentPlace( );
	}
}
