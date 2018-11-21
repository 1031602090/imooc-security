package com.imooc.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author hang
 */
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("time filter");
        Date date1 = new Date();
        chain.doFilter(request,response);
        System.out.println("耗时："+(System.currentTimeMillis()-date1.getTime()));
    }

    @Override
    public void destroy() {

    }
}
