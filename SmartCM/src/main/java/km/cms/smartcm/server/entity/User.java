package km.cms.smartcm.server.entity;

import java.io.Serializable;

import javax.inject.Named;
@Named
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6654861478000619720L;

	public User() {
		// TODO Auto-generated constructor stub
	}
	/** The name. */
	private String name="p";
	
	/** The password. */
	private String password="1";

	/**
	 * Instantiates a new certificate.
	 */
	public User(String name,String password) {
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
