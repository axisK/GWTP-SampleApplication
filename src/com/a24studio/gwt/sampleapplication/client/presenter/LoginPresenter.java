package com.a24studio.gwt.sampleapplication.client.presenter;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.a24studio.gwt.sampleapplication.client.event.HideSidebarEvent;
import com.a24studio.gwt.sampleapplication.client.event.HideTopbarEvent;
import com.a24studio.gwt.sampleapplication.client.event.ShowSidebarEvent;
import com.a24studio.gwt.sampleapplication.client.event.ShowTopbarEvent;
import com.a24studio.gwt.sampleapplication.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;

/**
 * Presenter for the login view.
 * 
 * @author Petrus Rademeyer
 * @since 29 November 2011
 */
public class LoginPresenter extends Presenter<LoginPresenter.MyView, LoginPresenter.MyProxy> {

	/**
	 * Constructor
	 * 
	 * @param eventBus Event bus to communicate with other views
	 * @param view The view to be used by this presenter.
	 * @param proxy The proxy for this presenter.
	 */
	@Inject
	public LoginPresenter( final EventBus eventBus, final MyView view, final MyProxy proxy ) {
		super( eventBus, view, proxy );
	}

	/**
	 * Requests that the presenter reveal itself in its parent presenter.
	 */
	@Override
	protected void revealInParent( ) {
		RevealContentEvent.fire( this, SplitPagePresenter.TYPE_CONTENT_SLOT, this );
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		
		boolean hideSidebar = Boolean.parseBoolean( request.getParameter( "hideSidebar", "false" ) );
		if ( hideSidebar ) {
			HideSidebarEvent.fire( this );
		} else {
			ShowSidebarEvent.fire( this );
		}

		boolean hideTopbar = Boolean.parseBoolean( request.getParameter( "hideTopbar", "false" ) );
		if ( hideTopbar ) {
			HideTopbarEvent.fire( this );
		} else {
			ShowTopbarEvent.fire( this );
		}
	}

	/**
	 * View associated with this presenter
	 * 
	 * @author Petrus Rademeyer
	 * @since 29 November 2011
	 */
	public interface MyView extends View {
		Button getLoginButton();
		TextBox getUsernameBox();
		TextBox getPasswordBox();
	}

	/**
	 * Proxy associated with this presenter.
	 * 
	 * @author Petrus Rademeyer
	 * @since 29 November 2011
	 */
	@ProxyCodeSplit
	@NameToken(NameTokens.login)
	public interface MyProxy extends ProxyPlace<LoginPresenter> {
	}
}
