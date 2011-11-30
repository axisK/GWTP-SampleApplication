package com.a24studio.gwt.sampleapplication.client.dispatch.handler;

import com.a24studio.gwt.sampleapplication.client.model.User;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.*;
import com.gwtplatform.dispatch.client.actionhandler.requestbuilder.AbstractRequestBuilderClientActionHandler;

public class LoginActionHandler extends AbstractRequestBuilderClientActionHandler<LoginAction, LoginResult> {

	protected LoginActionHandler( ) {
		super( LoginAction.class );
	}
	
	@Override
	protected LoginResult extractResult(Response response) {
		String responseText = response.getText( );
		JSONValue baseValue = JSONParser.parseStrict( responseText );
		JSONObject baseObject = baseValue.isObject( );

		if ( baseObject == null || !baseObject.containsKey( "success" ) ) {
			throw new RuntimeException( "Success key not found on response" );
		}
		JSONValue successValue = baseObject.get( "success" );
		JSONBoolean booleanValue;
		JSONString booleanStringValue;
		
		if ( (booleanValue = successValue.isBoolean( )) != null && booleanValue.booleanValue( ) == false ) {
			throw new RuntimeException( "Response indicated failure" );
		} else if ( (booleanStringValue = successValue.isString( ) ) != null && Boolean.parseBoolean( booleanStringValue.stringValue( ) ) == false ) {
			throw new RuntimeException( "Response indicated failure" );
		}

		JSONObject resultObject = null;
		if ( !baseObject.containsKey( "result" ) || ( resultObject = baseObject.get( "result" ).isObject( ) ) == null ) {
			throw new RuntimeException( "Result key not found on response" );
		}
		JSONValue userObject = null;
		if ( !resultObject.containsKey( "user" ) ) {
			throw new RuntimeException( "Malformed result" );
		}
		userObject = resultObject.get( "user" );
		
		if ( userObject.isNull( ) != null ) {
			return new LoginResult( null );
		}
		return new LoginResult( User.JSON_READER.read( userObject.isObject( ) ) );
	}

	@Override
	protected RequestBuilder getRequestBuilder(LoginAction action) {
		final String url = "/SampleApplication/loginUser.php?" +
				"username=" + action.getUsername( ) + 
				"&password=" + action.getPassword( );
		return new RequestBuilder( RequestBuilder.GET, url );
	}
	
}
