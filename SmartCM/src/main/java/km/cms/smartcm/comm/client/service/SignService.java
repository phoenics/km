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
package km.cms.smartcm.comm.client.service;

import km.cms.smartcm.comm.client.model.Certificate;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

// TODO: Auto-generated Javadoc
/**
 * The Interface SignService.
 * 
 * @author Phoenics chow
 * 
 *         新建日期:2013-12-7
 */
@RemoteServiceRelativePath("login.gwt")
public interface SignService extends RemoteService {

/**
 * Login.
 * 
 * @param certificate
 *            the certificate
 * @return true, if successful
 */
boolean login(Certificate certificate);

/**
 * Checks if is login.
 * 
 * @return true, if is login
 */
boolean isLogin();

/**
 * Logout.
 */
void logout();
	
}
