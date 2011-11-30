package com.a24studio.gwt.sampleapplication.client.presenter;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.a24studio.gwt.sampleapplication.client.event.HideSidebarEvent;
import com.a24studio.gwt.sampleapplication.client.event.HideSidebarHandler;
import com.a24studio.gwt.sampleapplication.client.event.ShowSidebarEvent;
import com.a24studio.gwt.sampleapplication.client.event.ShowSidebarEvent.ShowSidebarHandler;
import com.a24studio.gwt.sampleapplication.client.presenter.ApplicationPresenter;

public class SplitPagePresenter extends Presenter<SplitPagePresenter.MyView, SplitPagePresenter.MyProxy> implements HideSidebarHandler, ShowSidebarHandler {

	private boolean hideSidebar;

	/**
	 * Content slot that can be used by child presenters.
	 */
	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_SIDEBAR_SLOT = new Type<RevealContentHandler<?>>( );
	
	/**
	 * Content slot that can be used by child presenters.
	 */
	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_CONTENT_SLOT = new Type<RevealContentHandler<?>>( );
	
	@Inject
	public SplitPagePresenter(final EventBus eventBus, final MyView view, final MyProxy proxy) {
		super(eventBus, view, proxy);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire( this, ApplicationPresenter.TYPE_CONTENT_SLOT, this );
	}

	@Override
	protected void onReveal() {
		super.onReveal();

		getView( ).setSidebarVisible( !hideSidebar );
	}
	
	@ProxyEvent
	@Override
	public void onHideSidebar(HideSidebarEvent event) {
		hideSidebar = true;
		if ( isVisible( ) ) {
			getView( ).setSidebarVisible( !hideSidebar );
		}
	}
	
	@ProxyEvent
	@Override
	public void onShowSidebar(ShowSidebarEvent event) {
		hideSidebar = false;
		if ( isVisible( ) ) {
			getView( ).setSidebarVisible( !hideSidebar );
		}
	}

	public interface MyView extends View {
		void setSidebarVisible( boolean showSidebar );
	}

	@ProxyCodeSplit
	public interface MyProxy extends Proxy<SplitPagePresenter> {
	}
}
