package com.microservice.erp2017.service;

import com.microservice.erp2017.model.T_Auth;
import com.microservice.erp2017.model.vo.VO_T_Auth;
import com.microservice.erp2017.security.AuthServiceToken;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Reza
 */
public interface AuthService {
    Map signinPublic(VO_T_Auth vo);
    Map signupPublic(VO_T_Auth vo);
    Map signinPrivate(VO_T_Auth vo, HttpServletRequest httpRequest);
    Map signupPrivate(VO_T_Auth vo);
    Map signinSuperUser(VO_T_Auth vo, HttpServletRequest httpRequest);
    Map signupSuperUser(VO_T_Auth vo);
    Map loginMessage();
    T_Auth getOneByCode(String authCode);
    AuthServiceToken getTokenAuthentication();
}
