package com.hz.filter;

//import org.apache.log4j.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AdminPermissionFilter",urlPatterns = {"/seller/*"})
public class SellerPermissionFilter implements Filter {

    protected Logger logger = LogManager.getLogger();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        //如果是(登录界面,登录态失效界面)，直接放行
        if(servletRequest.getRequestURI().contains("/seller/login") ||
                servletRequest.getRequestURI().contains("/seller/account")
        ){
            chain.doFilter(request, response);
        } else {
            logger.info("检查管理员权限");
            Object o = servletRequest.getSession().getAttribute("adminId");
            if(o == null){
                logger.info("无管理权限，返回管理员登陆页");
                request.getRequestDispatcher("/seller/login").forward(request, response);
            } else {
                logger.info("权限验证成功，管理员ID：{}",o);
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
