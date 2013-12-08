package km.cms.smartcm.sign.client;

import km.cms.smartcm.sign.client.presenter.MainPresenter;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
@GinModules(SignGinjectorModule.class)
public interface SignGinjector extends Ginjector {
	MainPresenter getMainPresenter();
}
