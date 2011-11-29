package com.a24studio.gwt.sampleapplication.client.place;

/**
 * Name tokens convenience class for defining the named tokens of locations
 * in the application.
 * 
 * @author Petrus Rademeyer
 * @since 29 November 2011
 */
public class NameTokens {

	/**
	 * Login name token. The exclamation mark is for crawling support.
	 */
	public static final String login = "!login";

	/**
	 * Function for retrieving login name token, this is for use by instances 
	 * where a static class variable cannot be used.
	 * 
	 * @return
	 */
	public static String getLogin() {
		return login;
	}
}
