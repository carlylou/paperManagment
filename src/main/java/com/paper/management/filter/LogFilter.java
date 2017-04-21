package com.paper.management.filter;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by liyf on 8/18/2016.
 */
public class LogFilter implements Filter {
    protected final static Logger logger = LoggerFactory.getLogger(LogFilter.class);

    public static final String MULTIPART = "multipart/";

    private Set<String> excludesPattern;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String param = filterConfig.getInitParameter("exclusions");
        if(param != null && param.trim().length() != 0) {
            this.excludesPattern = new HashSet(Arrays.asList(param.split("\\s*,\\s*")));
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(isMultipartContent(request))
        {
            chain.doFilter(request,response);
            return;
        }
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (isExclusion(httpServletRequest.getRequestURI())) {
            chain.doFilter(request,response);
            return;
        }
        ResettableRequestWrapper resettableRequestWrapper = new ResettableRequestWrapper(httpServletRequest);
        long start = System.currentTimeMillis();
        chain.doFilter(resettableRequestWrapper,response);
        long end = System.currentTimeMillis();
        String log = String.format("%s 请求:%s 耗时 %d ms", httpServletRequest.getMethod(), httpServletRequest.getRequestURL() + (httpServletRequest.getQueryString() == null ? "" : "?" + httpServletRequest.getQueryString()), end - start);
        logger.info(log);
        logger.info("body参数: "+resettableRequestWrapper.getBody());
        if (httpServletRequest.getParameterMap() != null) {
            logger.info("参数: " + JSON.toJSONString(httpServletRequest.getParameterMap()));
        }
    }

    /**
     * 判断是否是包含文件.
     *
     * @param request
     * @return
     */
    public static final boolean isMultipartContent(ServletRequest request) {
        String contentType = request.getContentType();
        if (contentType == null) {
            return false;
        }
        if (contentType.toLowerCase().startsWith(MULTIPART)) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {

    }

    public boolean isExclusion(String requestURI) {
        if(this.excludesPattern == null) {
            return false;
        } else {
            Iterator iterator = this.excludesPattern.iterator();
            String pattern;
            do {
                if(!iterator.hasNext()) {
                    return false;
                }
                pattern = (String)iterator.next();
            } while(!matches(pattern, requestURI));
            return true;
        }
    }

    public boolean matches(String pattern, String source) {
        if(pattern != null && source != null) {
            pattern = pattern.trim();
            source = source.trim();
            int start;
            if(pattern.endsWith("*")) {
                start = pattern.length() - 1;
                if(source.length() >= start && pattern.substring(0, start).equals(source.substring(0, start))) {
                    return true;
                }
            } else if(pattern.startsWith("*")) {
                start = pattern.length() - 1;
                if(source.length() >= start && source.endsWith(pattern.substring(1))) {
                    return true;
                }
            } else if(pattern.contains("*")) {
                start = pattern.indexOf("*");
                int end = pattern.lastIndexOf("*");
                if(source.startsWith(pattern.substring(0, start)) && source.endsWith(pattern.substring(end + 1))) {
                    return true;
                }
            } else if(pattern.equals(source)) {
                return true;
            }

            return false;
        } else {
            return false;
        }
    }
}
