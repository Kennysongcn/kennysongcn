package com.kennysongcn.web.common.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;

public class UIUserFilter extends UserFilter {

	public final static String X_R = "X-Requested-With";
	public final static String X_R_VALUE = "XMLHttpRequest";
	
	/**
	 * 加入ajax查询参数，以便跳转至超时登录页面。
	 */
	@Override
	protected void redirectToLogin(ServletRequest request,
			ServletResponse response) throws IOException {
    	HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String xrv = httpServletRequest.getHeader(X_R);
		
		if (xrv != null && xrv.equalsIgnoreCase(X_R_VALUE)) {
			Map<String, String> queryParams = new HashMap<String, String>();
			queryParams.put("ajax", "true");
			WebUtils.issueRedirect(request, response, getLoginUrl(), queryParams);
		} else {
			super.redirectToLogin(request, response);
		}
	}
}
