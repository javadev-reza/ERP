package com.microservice.erp2017.security;

import com.fasterxml.jackson.core.JsonParseException;
import static com.microservice.erp2017.constant.WebConstant.MessageResource.*;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Reza
 */
public class FilterStateless extends GenericFilterBean {
    
    private final AuthServiceToken authServiceToken;

    public FilterStateless(AuthServiceToken authServiceToken) {
        this.authServiceToken = authServiceToken;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
	HttpServletRequest servletRequest = (HttpServletRequest)request;
        //----------------------------------------------------------------------
        HttpServletResponse servletResponse = (HttpServletResponse) response;
	//----------------------------------------------------------------------
        servletResponse.setHeader("Access-Control-Max-Age", "3600");
        //----------------------------------------------------------------------
	Authentication authentication = null;
	try {
            authentication = authServiceToken.getAuthentication(servletRequest);
	} catch (JsonParseException e) {
            logger.info(e.getMessage());
            servletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, LABEL_UNAUTHORIZED);
	}
        //----------------------------------------------------------------------
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(servletRequest, servletResponse);
        SecurityContextHolder.clearContext();
    }
}
