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
package km.cms.smartcm.server.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import km.cms.smartcm.server.services.SignServiceSupport;

// TODO: Auto-generated Javadoc
/**
 * Servlet Filter implementation class SessionFilter.
 * 
 * @author Phoenics chow
 * 
 *         新建日期:2013-12-8
 */
//@WebFilter("/SessionFilter")
public class SessionFilter implements Filter {
	
	/** The config. */
	private FilterConfig config;
	
	/** The logon_page. */
	private String logon_page;
	
	/** The home_page. */
	private String home_page;
	private String[] exclude_pages;
	
	/** The sign service support. */
	@Inject
	private SignServiceSupport signServiceSupport;

	/**
	 * Default constructor.
	 */
	public SessionFilter() {
	}

	/**
	 * Destroy.
	 * 
	 * @see Filter#destroy()
	 */
	public void destroy() {
		config = null;
	}

	/**
	 * Do filter.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param chain
	 *            the chain
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ServletException
	 *             the servlet exception
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rpo = (HttpServletResponse) response;
		String request_uri = req.getRequestURI();// 得到用户请求的URI
		String ctxPath = req.getContextPath();// 得到web应用程序的上下文路径
		//String uri = request_uri.substring(ctxPath.length()); // 去除上下文路径，得到剩余部分的路径
		if(exclude_pages!=null){
			for(String u :exclude_pages){
				if(request_uri.indexOf(u)>=0){
					chain.doFilter(request, response);
					return;
				}
			}
		}
		try {
			((HttpServletResponse) response).setHeader("Cache-Control","no-cache");
			  ((HttpServletResponse) response).setHeader("Pragma","no-cache");
			  ((HttpServletResponse) response).setDateHeader ("Expires", -1);
			if(signServiceSupport.isLogin()){
				chain.doFilter(request, response);
			}else if(request_uri.indexOf(logon_page)<0){
				rpo.sendRedirect(ctxPath+"/"+logon_page);
			}else{
				chain.doFilter(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * Inits the.
	 * 
	 * @param filterconfig
	 *            the filterconfig
	 * @throws ServletException
	 *             the servlet exception
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterconfig) throws ServletException {
		// 从部署描述符中获取登录页面和首页的URI
		this.config = filterconfig;
		logon_page = this.config.getInitParameter("LOGON_PAGE");
		home_page = this.config.getInitParameter("HOME_PAGE");
		String ex=this.config.getInitParameter("EXCLUDE_PAGE");
		if(ex!=null){
			 exclude_pages=ex.split(",");
		}
		//System.out.println(home_page);
		if (null == logon_page || null == home_page) {
			throw new ServletException("没有找到登录页面或主页");
		}
	}

}
