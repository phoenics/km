package km.cms.smartcm.server.services;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import km.cms.smartcm.comm.client.model.Certificate;
import km.cms.smartcm.comm.client.service.SignService;
import km.cms.smartcm.server.entity.User;
@Named("login")
@SessionScoped
public class SignServiceSupport  implements SignService, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5445729386382200512L;
	
//	@Inject
	private User user;
	private User currentUser=null;
	public SignServiceSupport()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean login(Certificate certificate) {
		if(certificate==null){
			return false;
		}
		this.user=new User();
		if(user.getName().equals(certificate.getName())){
			if(user.getPassword().equals(certificate.getPassword())){
				currentUser=user;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isLogin() {
		if(currentUser!=null)
			return true;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout() {
		currentUser=null;
	}
	public void setUser(User user){
		this.user=user;
	}

}
