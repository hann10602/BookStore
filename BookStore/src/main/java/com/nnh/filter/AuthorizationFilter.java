package com.nnh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nnh.model.UserModel;
import com.nnh.util.SessionUtil;

public class AuthorizationFilter implements Filter{

	private ServletContext context;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getRequestURI();
		if(url.startsWith("/BookStore/admin")) {
			UserModel um = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
			if(um != null) {
				if(um.getRoleId() == 1) {
					chain.doFilter(request, response);
				}else {
					resp.sendRedirect(req.getContextPath() + "/dang-nhap?active=login&message=not-permited&alert=danger");
				}
			}else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?active=login&message=not-login&alert=danger");
			}
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
