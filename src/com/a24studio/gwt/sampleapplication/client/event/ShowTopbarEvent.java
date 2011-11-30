package com.a24studio.gwt.sampleapplication.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class ShowTopbarEvent extends GwtEvent<ShowTopbarHandler>{
	private static final Type<ShowTopbarHandler> TYPE = new Type<ShowTopbarHandler>( );
	
	public static Type<ShowTopbarHandler> getType( ) {
		return TYPE;
	}

	public static void fire(HasHandlers source) {
		source.fireEvent( new ShowTopbarEvent( ) );
	}

	@Override
	protected void dispatch(ShowTopbarHandler handler) {
		handler.onShowTopbar( this );
	}
	
	@Override
	public Type<ShowTopbarHandler> getAssociatedType() {
		return getType( );
	}
}
