package com.microservice.erp2017.controller;

import com.microservice.erp2017.model.T_Auth;
import static com.microservice.erp2017.constant.WebConstant.MessageInfo.PASSWORD_ERROR_MESSAGE;
import static com.microservice.erp2017.constant.WebConstant.ValueMessageInfo.USERNAME_NOT_AVAILABLE;
import com.microservice.erp2017.model.vo.VO_T_Auth;

import com.microservice.erp2017.security.model.UserAuthentication;
import com.microservice.erp2017.util.CommonUtil;
import com.microservice.erp2017.util.RestUtil;
import io.swagger.annotations.ApiOperation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.erp2017.service.AuthService;

/**
 *
 * @author Reza
 */
@RestController
@RequestMapping("/auth-public")
public class AuthPublicController extends RestUtil{
    
    @Autowired AuthService authService;
    
    @ApiOperation("Api For Sign-In") 
    @PostMapping("/sign-in")
    public ResponseEntity signIn(@Valid @RequestBody VO_T_Auth vo, HttpServletResponse httpResponse) {
        try{
            if(CommonUtil.isNullOrEmpty(vo.getUserName()) || CommonUtil.isNullOrEmpty(vo.getPassword())) {
                setMessage(MessageInfo.WARNING_MESSAGE, ValueMessageInfo.EMPTY_USER_PASSWORD);
                setResponse(getJsonResponse(HttpStatus.BAD_REQUEST, getMessage()));
            } else{
                Map<String, Object> resultData = authService.signinPublic(vo);
                if(CommonUtil.isNullOrEmpty(resultData)){
                    setResponse(getJsonResponse(HttpStatus.NOT_FOUND, authService.loginMessage()));
                } else if(CommonUtil.isNotNullOrEmpty(resultData)){

                    //SET AUTHENTICATE--------------------------------------
                    T_Auth model = new T_Auth();
                    model.setUserName((String)resultData.get("userName"));
                    model.setPassword((String)resultData.get("password"));

                    //CREATE TOKEN------------------------------------------
                    GrantedAuthority authority = new SimpleGrantedAuthority("USER");
                    Boolean isValidToken = authService.getTokenAuthentication().addAuthentication(httpResponse, 
                            new UserAuthentication(
                                    new User(model.getUserName(), model.getPassword(), Arrays.asList(authority))));

                    //TOKEN RESPONSE----------------------------------------
                    if(CommonUtil.isNotNullOrEmpty(isValidToken)){
                        setMessage(MessageInfo.SUCCESS_MESSAGE, MessageResource.LABEL_SUCCESS);

                        //RESPONSE YANG DI TAMPILKAN
                        Map<String, Object> responseData = new HashMap<>();
                        responseData.put("userName", model.getUserName());

                        setResponse(getJsonResponse(responseData, HttpStatus.OK, getMessage()));
                    } else{
                        setMessage(MessageInfo.ERROR_MESSAGE, MessageResource.LABEL_ERROR);
                        setResponse(getJsonResponse(HttpStatus.INTERNAL_SERVER_ERROR, getMessage()));
                    }
                }
            }
        }catch(Exception e){
            getException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return getResponse();
    }

    @ApiOperation("Api For User Registration")
    @PostMapping("/sign-up")
    public ResponseEntity signUp(@Valid @RequestBody VO_T_Auth vo, HttpServletResponse httpResponse) {
        try{
            Map<String, Object> resultMap = authService.signupPublic(vo);
            if(CommonUtil.isNotNullOrEmpty(resultMap)){
                GrantedAuthority authority = new SimpleGrantedAuthority("USER");
                Boolean isValidToken = authService.getTokenAuthentication().addAuthentication(httpResponse, 
                        new UserAuthentication(
                                new User(vo.getUserName(), vo.getPassword(), Arrays.asList(authority))));
                if(CommonUtil.isNotNullOrEmpty(isValidToken)){
                    setMessage(MessageInfo.SUCCESS_MESSAGE, MessageResource.LABEL_SUCCESS);
                    setResponse(getJsonResponse(resultMap, HttpStatus.OK, getMessage()));
                } else{
                    setMessage(MessageInfo.ERROR_MESSAGE, MessageResource.LABEL_ERROR);
                    setResponse(getJsonResponse(HttpStatus.INTERNAL_SERVER_ERROR, getMessage()));
                }
            } else{
                setMessage(MessageInfo.WARNING_MESSAGE, USERNAME_NOT_AVAILABLE);
                setResponse(getJsonResponse(HttpStatus.FORBIDDEN, getMessage()));
            }
        }catch(Exception e){
            getException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return getResponse();
    }
    
}
