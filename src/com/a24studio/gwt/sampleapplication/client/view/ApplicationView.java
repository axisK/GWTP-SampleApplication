package com.a24studio.gwt.sampleapplication.client.view;

import com.a24studio.gwt.sampleapplication.client.presenter.ApplicationPresenter;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * Application view, this is the top level view and will be used to contain other views.
 * 
 * @author Petrus Rademeyer
 * @since 29 November 2011
 */
public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
	public interface Binder extends UiBinder<Widget, ApplicationView> {}

	private final Widget widget;
	@UiField LayoutPanel layoutPanel;
	@UiField FlowPanel topSlot;
	@UiField FlowPanel contentSlot;

	@Inject
	public ApplicationView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		if ( slot == ApplicationPresenter.TYPE_CONTENT_SLOT ) {
			contentSlot.clear( );
			contentSlot.add( content );
		} else {
			super.setInSlot( slot, content );
		}
	}
	
	@Override
	public void setTopbarVisible(boolean visible) {
		topSlot.setStyleName( "hiddenItem", !visible );
		if ( visible ) {
			layoutPanel.setWidgetTopBottom( contentSlot, 44, Unit.PX, 0, Unit.PX );
		} else {
			layoutPanel.setWidgetTopBottom( contentSlot, 0, Unit.PX, 0, Unit.PX );
			
		}
	}
}
