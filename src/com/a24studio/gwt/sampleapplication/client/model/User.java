package com.a24studio.gwt.sampleapplication.client.model;

import com.google.gwt.core.client.GWT;

import name.pehl.piriti.json.client.JsonReader;
import name.pehl.piriti.json.client.JsonWriter;

public class User {
	public interface JsonModuleReader extends JsonReader<User> {}
	public interface JsonModuleWriter extends JsonWriter<User> {}

	public static final JsonModuleReader JSON_READER = GWT.create( JsonModuleReader.class );
	public static final JsonModuleWriter JSON_WRITER = GWT.create( JsonModuleWriter.class );

	public String username;
	public String firstname;
	public String lastname;
}
