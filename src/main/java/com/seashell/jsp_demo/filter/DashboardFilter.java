package com.seashell.jsp_demo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DashboardFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        long start = System.currentTimeMillis();
System.out.println("Filter front running...");
        try {
            chain.doFilter(request, response);
        } finally {
            long elapsed = System.currentTimeMillis() - start;

            // structured log
            String method = req.getMethod();
            String uri = req.getRequestURI();
            int status = resp.getStatus();

            System.out.printf("{\"method\":\"%s\",\"uri\":\"%s\",\"status\":%d,\"elapsedMs\":%d}%n",
                    method, uri, status, elapsed);
        }
    }

    @Override
    public void destroy() {  //應用關掉的時候 tomcat會自動呼叫，結束此 singleton

    }
}
