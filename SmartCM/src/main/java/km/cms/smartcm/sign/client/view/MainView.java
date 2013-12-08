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
package km.cms.smartcm.sign.client.view;


import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;

import km.cms.smartcm.sign.client.presenter.MainPresenter;

/**
 * The Class MainView.
 * 
 * @author Phoenics chow
 * 
 *         新建日期:2013-12-8
 */
public class MainView extends Composite implements MainPresenter.Display {
	
	/** The main presenter. */
	private  MainPresenter mainPresenter;
	
	/**
	 * The Interface MainViewUiBinder.
	 * 
	 * @author Phoenics chow
	 * 
	 *         新建日期:2013-12-8
	 */
	interface MainViewUiBinder extends UiBinder<Widget, MainView> {
	}
	
	/**
	 * Instantiates a new main view.
	 * 
	 * @param uiBinder
	 *            the ui binder
	 * @param mainPresenter
	 *            the main presenter
	 */
	@Inject
	public MainView(MainViewUiBinder uiBinder) {
		//this .mainPresenter=mainPresenter;
		initWidget(uiBinder.createAndBindUi(this));
	}
	@Override
	public void setPresenter(MainPresenter presenter){
		this .mainPresenter=presenter;
	   }
	
	/** The name. */
	@UiField
	TextField name;
	
	/** The password. */
	@UiField
	PasswordField password;


	/* (non-Javadoc)
	 * @see km.cms.smartcm.sign.client.Presenter.MainPresenter.Display#getName()
	 */
	@Override
	public HasValue<String> getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see km.cms.smartcm.sign.client.Presenter.MainPresenter.Display#getPassword()
	 */
	@Override
	public HasValue<String> getPassword() {
		return password;
	}
	
	/**
	 * On select.
	 * 
	 * @param event
	 *            the event
	 */
	@UiHandler("login")
	void onSelect(SelectEvent event) {
		mainPresenter.onLogin();
	}

}
