package com.a24studio.gwt.sampleapplication.client.gin;

import com.a24studio.gwt.sampleapplication.client.dispatch.handler.LoginActionHandler;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.client.actionhandler.DefaultClientActionHandlerRegistry;

public class ServiceActionHandlerRegistry extends DefaultClientActionHandlerRegistry {

	@Inject
	public ServiceActionHandlerRegistry( final LoginActionHandler loginActionHandler ) {
		register( loginActionHandler );
	}
}
