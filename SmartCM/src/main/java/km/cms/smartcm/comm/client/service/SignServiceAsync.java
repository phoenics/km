package km.cms.smartcm.comm.client.service;

import km.cms.smartcm.comm.client.model.Certificate;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SignServiceAsync {

	void isLogin(AsyncCallback<Boolean> callback);

	void login(Certificate certificate, AsyncCallback<Boolean> callback);

	void logout(AsyncCallback<Void> callback);

}
