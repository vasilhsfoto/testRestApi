package com.company.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {
	private FilterConfig filterConfig;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		String remoteAddress = request.getRemoteAddr();
		String uri = ((HttpServletRequest) request).getRequestURI();
		String protocol = request.getProtocol();
		
		//stop the interception and call the corresponding servlet
		chain.doFilter(request, response);
		
		filterConfig.getServletContext().log("my message in Tomcat's log....");
	}

	public void destroy() {
	}
}
