package com.a24studio.gwt.sampleapplication.client.gin;

import com.google.gwt.inject.client.AbstractGinModule;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;

public class ServicesModule extends AbstractGinModule {

	@Override
	protected void configure() {
		install( new DispatchAsyncModule.Builder( ).clientActionHandlerRegistry( ServiceActionHandlerRegistry.class ).build( ) );
	}
}
