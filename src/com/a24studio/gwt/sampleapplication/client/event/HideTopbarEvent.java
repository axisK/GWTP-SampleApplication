package com.a24studio.gwt.sampleapplication.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class HideTopbarEvent extends GwtEvent<HideTopbarHandler>{
	private static final Type<HideTopbarHandler> TYPE = new Type<HideTopbarHandler>( );
	
	public static Type<HideTopbarHandler> getType( ) {
		return TYPE;
	}

	public static void fire(HasHandlers source) {
		source.fireEvent( new HideTopbarEvent( ) );
	}

	@Override
	protected void dispatch(HideTopbarHandler handler) {
		handler.onHideTopbar( this );
	}
	
	@Override
	public Type<HideTopbarHandler> getAssociatedType() {
		return getType( );
	}
}
