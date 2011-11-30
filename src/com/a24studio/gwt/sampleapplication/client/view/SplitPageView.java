package com.a24studio.gwt.sampleapplication.client.view;

import com.a24studio.gwt.sampleapplication.client.presenter.SplitPagePresenter;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class SplitPageView extends ViewImpl implements SplitPagePresenter.MyView {
	public interface Binder extends UiBinder<Widget, SplitPageView> {
	}

	private final Widget widget;
	@UiField LayoutPanel layoutPanel;
	@UiField FlowPanel sidebarSlot;
	@UiField FlowPanel contentSlot;

	@Inject
	public SplitPageView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}
	
	@Override
	public void setInSlot(Object slot, Widget content) {
		if ( slot == SplitPagePresenter.TYPE_CONTENT_SLOT ) {
			contentSlot.clear( );
			if ( content != null ) {
				contentSlot.add( content );
			}
		} else if ( slot == SplitPagePresenter.TYPE_SIDEBAR_SLOT ) {
			sidebarSlot.clear( );
			if ( content != null ) {
				sidebarSlot.add( content );
			}
		} else {
			super.setInSlot( slot, content );
		}
	}
	
	@Override
	public void setSidebarVisible(boolean showSidebar) {
		sidebarSlot.setStyleName( "hiddenItem", showSidebar );
		if ( showSidebar ) {
			layoutPanel.setWidgetLeftRight( contentSlot, 25, Unit.PCT, 0, Unit.PX );
		} else {
			layoutPanel.setWidgetLeftRight( contentSlot, 0, Unit.PX, 0, Unit.PX );
		}
	}
}
