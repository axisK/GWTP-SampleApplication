package com.a24studio.gwt.sampleapplication.client.place;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.proxy.PlaceManagerImpl;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.TokenFormatter;

/**
 * The default place manager implementation for our application.
 * 
 * @author Petrus Rademeyer
 * @since 29 November 2011
 */
public class ClientPlaceManager extends PlaceManagerImpl {

	/**
	 * Default place request where the user will be directed if he comes into the
	 * application without a target location.
	 */
	private final PlaceRequest defaultPlaceRequest;

	/**
	 * Default error place request where the user will be directed if he goes to an
	 * invalid location in the application.
	 */
	private final PlaceRequest defaultErrorPlaceRequest;

	/**
	 * Constructor
	 * 
	 * @param eventBus The eventbus instance to use when communicating with presenters.
	 * @param tokenFormatter Formats tokens from {@code String} values to {@link PlaceRequest}
	 * @param defaultPlaceNameToken The default target location in the application.
	 * @param defaultErrorPlaceNameToken The default target location in the application.
	 */
	@Inject
	public ClientPlaceManager( final EventBus eventBus, final TokenFormatter tokenFormatter, @DefaultPlace final String defaultPlaceNameToken, @DefaultErrorPlace final String defaultErrorPlaceNameToken ) {
		super( eventBus, tokenFormatter );
		this.defaultPlaceRequest = new PlaceRequest( defaultPlaceNameToken );
		this.defaultErrorPlaceRequest = new PlaceRequest( defaultErrorPlaceNameToken );
	}

	/**
	 * Takes the user to the default page in the application
	 */
	@Override
	public void revealDefaultPlace( ) {
		revealPlace( defaultPlaceRequest, false );
	}
	
	/**
	 * Takes the user to the default error page in the application.
	 */
	@Override
	public void revealErrorPlace(String invalidHistoryToken) {
		if ( defaultErrorPlaceRequest == null ) {
			super.revealErrorPlace(invalidHistoryToken);
		} else {
			revealPlace( defaultPlaceRequest, false );
		}
	}
}
