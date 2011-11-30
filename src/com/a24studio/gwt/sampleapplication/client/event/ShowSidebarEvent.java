package com.a24studio.gwt.sampleapplication.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HasHandlers;

public class ShowSidebarEvent extends GwtEvent<ShowSidebarEvent.ShowSidebarHandler> {
	public interface ShowSidebarHandler extends EventHandler {
		void onShowSidebar(ShowSidebarEvent event);
	}
	
	public static Type<ShowSidebarHandler> TYPE = new Type<ShowSidebarHandler>();

	public ShowSidebarEvent() {
	}

	@Override
	protected void dispatch(ShowSidebarHandler handler) {
		handler.onShowSidebar(this);
	}

	@Override
	public Type<ShowSidebarHandler> getAssociatedType() {
		return TYPE;
	}

	public static Type<ShowSidebarHandler> getType() {
		return TYPE;
	}

	public static void fire(HasHandlers source) {
		source.fireEvent(new ShowSidebarEvent());
	}
}
