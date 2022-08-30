package com.hz.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "UserPermissionFilter",urlPatterns = {"/purchase/*"})
public class UserPermissionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        Object o = servletRequest.getSession().getAttribute("user");
        if(o != null){
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
