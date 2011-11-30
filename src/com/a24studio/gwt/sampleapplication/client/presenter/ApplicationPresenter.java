package com.a24studio.gwt.sampleapplication.client.presenter;

import com.a24studio.gwt.sampleapplication.client.event.HideTopbarEvent;
import com.a24studio.gwt.sampleapplication.client.event.HideTopbarHandler;
import com.a24studio.gwt.sampleapplication.client.event.ShowTopbarEvent;
import com.a24studio.gwt.sampleapplication.client.event.ShowTopbarHandler;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.ProxyEvent;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;

/**
 * Presenter for the application view, this is the top level container of content.
 * 
 * @author Petrus Rademeyer
 * @since 29 November 2011
 */
public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> implements HideTopbarHandler, ShowTopbarHandler {

	private boolean hideTopbar = false;

	/**
	 * Event bus used to communicate with other presenters.
	 */
	private final EventBus eventBus;

	/**
	 * Content slot that can be used by child presenters.
	 */
	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_CONTENT_SLOT = new Type<RevealContentHandler<?>>( );

	/**
	 * Constructor
	 * 
	 * @param eventBus Event bus to communicate with other views
	 * @param view The view to be used by this presenter.
	 * @param proxy The proxy for this presenter.
	 */
	@Inject
	public ApplicationPresenter( final EventBus eventBus, final MyView view, final MyProxy proxy ) {
		super( eventBus, view, proxy );
		this.eventBus = eventBus;
	}

	@Override
	protected void onReveal() {
		super.onReveal();

		getView( ).setTopbarVisible( !hideTopbar );
	}

	/**
	 * Requests that the presenter reveal itself in its parent presenter.
	 */
	@Override
	protected void revealInParent() {
		RevealRootLayoutContentEvent.fire( eventBus, this );
	}

	@ProxyEvent
	@Override
	public void onHideTopbar(HideTopbarEvent event) {
		hideTopbar = true;
		if ( isVisible( ) ) {
			getView( ).setTopbarVisible( !hideTopbar );
		}
	}

	@ProxyEvent
	@Override
	public void onShowTopbar(ShowTopbarEvent event) {
		hideTopbar = false;
		if ( isVisible( ) ) {
			getView( ).setTopbarVisible( !hideTopbar );
		}
	}

	/**
	 * View associated with this presenter
	 * 
	 * @author Petrus Rademeyer
	 * @since 29 November 2011
	 */
	public interface MyView extends View {
		void setTopbarVisible( boolean visible );
	}

	/**
	 * Proxy associated with this presenter.
	 * 
	 * @author Petrus Rademeyer
	 * @since 29 November 2011
	 */
	@ProxyCodeSplit
	public interface MyProxy extends Proxy<ApplicationPresenter> {
	}
}
