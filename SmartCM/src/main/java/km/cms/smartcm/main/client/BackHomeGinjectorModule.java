package km.cms.smartcm.main.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class BackHomeGinjectorModule extends AbstractGinModule { 

	public BackHomeGinjectorModule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void configure() {
		this.bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		
	}

}
