package km.cms.smartcm.server.servlet;

import java.util.Set;

import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;






import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet implementation class Switchboard
 */
@WebServlet("*.gwt")
public class Switchboard extends RemoteServiceServlet  {
	private static final long serialVersionUID = 1L;
	@Inject
	BeanManager beanManager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Switchboard() {
        super();
        // TODO Auto-generated constructor stub
    }


	public String processCall(String payload) throws SerializationException {
	    // First, check for possible XSRF situation
	    checkPermutationStrongName();

	    try {
	    	Object handler = getBean(getThreadLocalRequest());
	      RPCRequest rpcRequest = RPC.decodeRequest(payload, handler.getClass(), this);
	      onAfterRequestDeserialized(rpcRequest);
	      return RPC.invokeAndEncodeResponse(handler, rpcRequest.getMethod(),
	          rpcRequest.getParameters(), rpcRequest.getSerializationPolicy(),
	          rpcRequest.getFlags());
	    } catch (IncompatibleRemoteServiceException ex) {
	      log(
	          "An IncompatibleRemoteServiceException was thrown while processing this call.",
	          ex);
	      return RPC.encodeResponseForFailure(null, ex);
	    } catch (RpcTokenException tokenException) {
	      log("An RpcTokenException was thrown while processing this call.",
	          tokenException);
	      return RPC.encodeResponseForFailure(null, tokenException);
	    }
	  }
	
	protected Object getBean(HttpServletRequest request) {  
        String service = getService(request);  
        Object bean = getBean(service);  
        if (!(bean instanceof RemoteService)) {  
            throw new IllegalArgumentException(  
                    "CDI bean is not a GWT RemoteService: " + service + " (" + bean + ")");  
        }  
       
        return bean;  
    }  
  
    protected String getService(HttpServletRequest request) {  
        String url = request.getRequestURI();  
        String service = url.substring(url.lastIndexOf("/") + 1);  
        service=service.substring(0,service.lastIndexOf(".gwt") );  
        return service;  
    }  
  
    protected Object getBean(String name) {  
    	if(name==null)
    		return null;
    	Object serviceObject =null;
    	Set<Bean<?>>beans=this.beanManager.getBeans(name);
    	Bean<?> bean=beans.iterator().next();
    	CreationalContext<?> ctx = this.beanManager.createCreationalContext(bean);
    	serviceObject = this.beanManager.getReference(bean, bean.getBeanClass(), ctx);
     return serviceObject;
    }  
}
