package com.nnh.util;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	private static SessionUtil su = null;
	
	public static SessionUtil getInstance() {
		if(su == null) {
			su = new SessionUtil();
		}
		return su;
	}
	
	public void removeValue(HttpServletRequest req, String key) {
		req.getSession().removeAttribute(key);
	}
	
	public void putValue(HttpServletRequest req, String key, Object value) {
		req.getSession().setAttribute(key, value);
	}
	
	public Object getValue(HttpServletRequest req, String key) {
		return req.getSession().getAttribute(key);
		
	}
}
