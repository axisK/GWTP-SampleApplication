package com.a24studio.gwt.sampleapplication.client.place;

import com.google.inject.BindingAnnotation;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Default place interface annotation used to later on set the default place
 * of the application at configuration.
 * 
 * @author Petrus Rademeyer
 * @since 29 November 2011
 */
@BindingAnnotation
@Target({ FIELD, PARAMETER, METHOD })
@Retention(RUNTIME)
public @interface DefaultPlace {
}
