package com.example.ZuulServer;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Praveenkumar on 1/28/2022.
 */
@Component
public class SimpleZuulFilter extends ZuulFilter {
    //creating Logger object
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public int filterOrder() {
        return 1; //setting filter order to 1
    }

    @Override
    public boolean shouldFilter() {
        return true; //executing filter for every request
    }

    //log the content of the request
    @Override
    public Object run() throws ZuulException {
//getting the current HTTP request that is to be handle
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
//prints the detail of the requestin the log
        logger.info("request -> {} request uri-> {}", request, request.getRequestURI());
        return null;
    }

    @Override
    public String filterType() {
        return "pre"; //intercept all the request before execution
    }
}
