package com.a24studio.gwt.sampleapplication.client.gin;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

/**
 * Gin Injector, this is used to build up the dependency graphs and
 * uses bindings to inject objects. An implementation of this will be generated
 * by GWT when we request it.
 * 
 * @author Petrus Rademeyer
 * @since 29 November 2011
 */
@GinModules( { LayoutModule.class } )
public interface GInjector extends Ginjector {

	/**
	 * The event bus that we use to communicate between parent and child presenters.
	 * 
	 * @return
	 */
	EventBus getEventBus();

	/**
	 * Place manager used to change location in the application with history support.
	 * 
	 * @return
	 */
	PlaceManager getPlaceManager();
}
