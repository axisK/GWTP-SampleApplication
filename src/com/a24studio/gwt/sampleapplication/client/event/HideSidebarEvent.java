package com.a24studio.gwt.sampleapplication.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HasHandlers;

public class HideSidebarEvent extends GwtEvent<HideSidebarHandler>{
	private static final Type<HideSidebarHandler> TYPE = new Type<HideSidebarHandler>( );
	
	public static Type<HideSidebarHandler> getType( ){
		return TYPE;
	}

	public static void fire(HasHandlers source) {
		source.fireEvent( new HideSidebarEvent( ) );
	}

	public HideSidebarEvent( ) {
	}
	
	@Override
	protected void dispatch(HideSidebarHandler handler) {
		handler.onHideSidebar( this );
	}
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<HideSidebarHandler> getAssociatedType() {
		return getType( );
	}
}
