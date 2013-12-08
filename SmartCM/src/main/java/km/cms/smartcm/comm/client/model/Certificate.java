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

package km.cms.smartcm.comm.client.model;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class Certificate.登录的凭据，通过这里用户名和密码，提交到后台，通过验证
 * 
 * @author Phoenics chow
 * 
 *         新建日期:2013-12-7
 */
public class Certificate implements Serializable {
	
	private static final long serialVersionUID = 4681044145143639711L;

	/** The name. */
	private String name;
	
	/** The password. */
	private String password;

	/**
	 * Instantiates a new certificate.
	 */
	public Certificate(){
		
	}
	public Certificate(String name,String password) {
		this.name=name;
		this.password=password;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
