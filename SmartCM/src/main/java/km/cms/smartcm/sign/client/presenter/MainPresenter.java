/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package km.cms.smartcm.sign.client.presenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.info.Info;

import km.cms.smartcm.comm.client.model.Certificate;
import km.cms.smartcm.comm.client.presenter.Presenter;
import km.cms.smartcm.comm.client.service.SignServiceAsync;
import km.cms.smartcm.comm.client.view.DisplayView;

// TODO: Auto-generated Javadoc
/**
 * The Class MainPresenter.
 * 
 * @author Phoenics chow
 * 
 *         新建日期:2013-12-7
 */
public class MainPresenter implements Presenter {

	public interface Display extends DisplayView<MainPresenter>{
		
		/**
		 * Gets the name.
		 * 
		 * @return the name
		 */
		HasValue<String> getName();

		/**
		 * Gets the password.
		 * 
		 * @return the password
		 */
		HasValue<String> getPassword();
	}

	/** The main view. */
	private final Display mainView;
	
	/** The sign service async. */
	private final SignServiceAsync signServiceAsync;

	/**
	 * Instantiates a new main presenter.
	 * 
	 * @param mainView
	 *            the main view
	 * @param signServiceAsync
	 *            the sign service async
	 */
	@Inject
	public MainPresenter(Display display, SignServiceAsync signServiceAsync) {
		this.mainView = display;
		this.mainView.setPresenter(this);
		this.signServiceAsync = signServiceAsync;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * km.cms.smartcm.comm.client.Presenter.Presenter#goShow(com.google.gwt.
	 * user.client.ui.IsWidget)
	 */
	@Override
	public void goShow(HasWidgets widghts) {
		widghts.add(mainView.asWidget());
	}

	/**
	 * On login.
	 */
	public void onLogin() {
		signServiceAsync.login(new Certificate(mainView.getName().getValue(),
				mainView.getPassword().getValue()),
				new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						Info.display("登录系统", "网络或服务器故障导致登录失败");  
					}

					@Override
					public void onSuccess(Boolean result) {
						if(result){
							Info.display("登录系统", "成功登录系统，正在转向主页");  
							Window.Location.replace(GWT.getHostPageBaseURL()+"index.jsp");
						}else{
							Info.display("登录系统", "用户名或者密码错误，登录失败");  
						}
						

					}

				});
	}

}
