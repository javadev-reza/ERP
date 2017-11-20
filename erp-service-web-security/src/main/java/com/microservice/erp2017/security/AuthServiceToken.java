package com.microservice.erp2017.security;

import com.microservice.erp2017.service.impl.UserService;
import com.microservice.erp2017.security.model.UserAuthentication;
import com.fasterxml.jackson.core.JsonParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import static com.microservice.erp2017.constant.WebConstant.Header.AUTH_TOKEN;
import static com.microservice.erp2017.constant.WebConstant.Header.AUTHORIZATION;

@Component
public class AuthServiceToken {
    
    public static TokenHandler tokenHandler;
	
    public AuthServiceToken(String secret, UserService userService) {
        tokenHandler = new TokenHandler(secret, userService);
    }

    public Boolean addAuthentication(HttpServletResponse httpResponse, UserAuthentication authentication) {
        final User user = authentication.getDetails();
        //----------------------------------------------------------------------
        String token = tokenHandler.createTokenForUser(user);
        //----------------------------------------------------------------------
        if(user.equals(tokenHandler.parseUserFromToken(token))){
            httpResponse.setHeader(AUTH_TOKEN, token);
            //------------------------------------------------------------------
            return true;
        } else{
            httpResponse.setHeader(AUTH_TOKEN, null);
            //------------------------------------------------------------------
            return false;
        }
    }

    public Authentication getAuthentication(HttpServletRequest request) throws JsonParseException {
        String tokenParam;
	try {
            final String[] tokens = request.getQueryString().split("&");
		for (String tokenTemp : tokens) {
                    if (tokenTemp.toLowerCase().contains(AUTH_TOKEN.toLowerCase())) {
			tokenParam = tokenTemp.split("=")[1];
			final User user = tokenHandler.parseUserFromToken(tokenParam);
                        if (user != null) {
                            return new UserAuthentication(user);
                        }
                    }
		}
	} catch (Exception e) {
	}
        String token1, token2;
        try {
            token1 = request.getHeader(AUTHORIZATION.toLowerCase());
            token2 = request.getHeader(AUTH_TOKEN.toLowerCase());
            boolean toke1 = token1 == null || "".equals(token1.trim()) || "aa".equals(token1.trim().toLowerCase());
            boolean toke2 = token2 == null || "".equals(token2.trim()) || "aa".equals(token2.trim().toLowerCase());
            if (toke1) {
		if (toke2) {
                    return null;
		}
                token1 = token2;
            }
        final User user = tokenHandler.parseUserFromToken(token1);
            if (user != null) {
                return new UserAuthentication(user);
            }
	} catch (Exception e) {
	}
	return null;
    }
}
