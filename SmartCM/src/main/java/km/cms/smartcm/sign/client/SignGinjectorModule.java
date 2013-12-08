package km.cms.smartcm.sign.client;



import km.cms.smartcm.sign.client.presenter.MainPresenter;
import km.cms.smartcm.sign.client.view.MainView;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class SignGinjectorModule extends AbstractGinModule { 

	@Override
	protected void configure() {
		this.bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		this.bind(MainPresenter.Display.class).to(MainView.class);
		
	}

}
