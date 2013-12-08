package km.cms.smartcm.main.client;


import km.cms.smartcm.main.client.presenter.MainPresenter;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
@GinModules(BackHomeGinjectorModule.class)
public interface BackHomeGinjector extends Ginjector {
	MainPresenter getMainPresenter();
}
