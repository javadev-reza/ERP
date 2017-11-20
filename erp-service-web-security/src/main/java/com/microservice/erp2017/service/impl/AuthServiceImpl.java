package com.microservice.erp2017.service.impl;

import static com.microservice.erp2017.constant.WebConstant.Header.REFFERAL;
import static com.microservice.erp2017.constant.WebConstant.MessageInfo.ACCOUNT_ERROR_MESSAGE;
import static com.microservice.erp2017.constant.WebConstant.MessageInfo.PASSWORD_ERROR_MESSAGE;
import static com.microservice.erp2017.constant.WebConstant.MessageInfo.USERNAME_ERROR_MESSAGE;
import com.microservice.erp2017.security.AuthServiceToken;
import static com.microservice.erp2017.constant.WebConstant.ValueMessageInfo.PASSWORD_IS_INCORECT;
import static com.microservice.erp2017.constant.WebConstant.ValueMessageInfo.USERNAME_IS_INCORECT;
import com.microservice.erp2017.model.BaseServiceImpl;
import com.microservice.erp2017.service.repo.AuthRepo;
import com.microservice.erp2017.model.T_Auth;
import com.microservice.erp2017.model.vo.VO_T_Auth;
import com.microservice.erp2017.util.CommonUtil;
import com.microservice.erp2017.util.PasswordUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.microservice.erp2017.service.AuthService;
import static com.microservice.erp2017.constant.WebConstant.ValueMessageInfo.ACCESS_DENIED;
import com.microservice.erp2017.model.T_Company;
import com.microservice.erp2017.model.T_Employee;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Reza
 */
@Service("AuthGlobalService")
public class AuthServiceImpl extends BaseServiceImpl implements AuthService {
    
    @Autowired 
    private AuthRepo authRepo;
    
    @Autowired 
    private AuthServiceToken authServiceToken;
    
    @Override
    public AuthServiceToken getTokenAuthentication() {
        return authServiceToken;
    }
    
    @Override
    public Map loginMessage(){
        return super.getLoginMessage();
    }
    
    @Override
    public Map signinPublic(VO_T_Auth vo) {
        return signin(vo, 1, null);
    }

    @Override
    public Map signupPublic(VO_T_Auth vo) {
        return signup(vo, 1);
    }

    @Override
    public Map signinPrivate(VO_T_Auth vo, HttpServletRequest httpRequest) {
       return signin(vo, 2, httpRequest.getHeader(REFFERAL));
    }

    @Override
    public Map signupPrivate(VO_T_Auth vo) {
        return signup(vo, 2);
    }
    
    @Override
    public Map signinSuperUser(VO_T_Auth vo, HttpServletRequest httpRequest) {
       return signin(vo, 3, httpRequest.getHeader(REFFERAL));
    }

    @Override
    public Map signupSuperUser(VO_T_Auth vo) {
        return signup(vo, 3);
    }
    
    @Override
    public T_Auth getOneByCode(String authCode){
       return authRepo.findOne(authCode);
    }
    
    private Map signin(VO_T_Auth vo, Integer accountStatus, String refferal) {
        Map<String, Object> resultMap = new HashMap<>();
        //----------------------------------------------------------------------
        T_Auth auth = authRepo.loadUserByUsername(vo.getUserName());
        if(CommonUtil.isNotNullOrEmpty(auth)){
            if(auth.getAuthStatusId().equals(accountStatus) || auth.getAuthStatusId().equals(3)){
                
                //--------------------------------------------------------------
                try {
                    Boolean isValidPassword = false;
                    if(new PasswordUtil().isPasswordEqual(vo.getPassword(), auth.getPassword())){
                        isValidPassword = true;
                    }
                    if(isValidPassword){
                        if(auth.getAuthStatusId()==3){
                            T_Company company = authRepo.getCompany(refferal, auth.getCode());
                            if(CommonUtil.isNotNullOrEmpty(company)){
                                resultMap.put("userName", auth.getUserName());
                                resultMap.put("password", auth.getPassword());
                                setloginMessage(null, null);
                            } else{
                                setloginMessage(ACCOUNT_ERROR_MESSAGE, ACCESS_DENIED);
                            }
                        } else if(auth.getAuthStatusId()==2){
                            T_Employee employee = authRepo.getEmployee(refferal, auth.getCode());
                            if(CommonUtil.isNotNullOrEmpty(employee)){
                                resultMap.put("userName", auth.getUserName());
                                resultMap.put("password", auth.getPassword());
                                setloginMessage(null, null);
                            } else{
                                setloginMessage(ACCOUNT_ERROR_MESSAGE, ACCESS_DENIED);
                            }
                        } else{
                            resultMap.put("userName", auth.getUserName());
                            resultMap.put("password", auth.getPassword());
                            setloginMessage(null, null);
                        }
                    } else{
                        setloginMessage(PASSWORD_ERROR_MESSAGE, PASSWORD_IS_INCORECT);
                    }
                } catch (IOException e) {
                    getException(e);
                }
            }else{
                setloginMessage(ACCOUNT_ERROR_MESSAGE, ACCESS_DENIED);
            }
        }else{
            setloginMessage(USERNAME_ERROR_MESSAGE, USERNAME_IS_INCORECT);
        }
        return resultMap;    
    }

    private Map signup(VO_T_Auth vo, Integer accountStatus) {
        Map<String, Object> resultMap = new HashMap<>();
        //---------------------------------------------------------------------- 
        if(CommonUtil.isNotNullOrEmpty(vo)){
            T_Auth auth = authRepo.loadUserByUsername(vo.getUserName());
            //------------------------------------------------------------------
            if(CommonUtil.isNullOrEmpty(auth)){
                T_Auth autentikasi = new T_Auth();
                //--------------------------------------------------------------
                autentikasi.setStatusEnabled(true);
                //--------------------------------------------------------------
                autentikasi.setUserName(vo.getUserName());
                //--------------------------------------------------------------
                autentikasi.setAuthStatusId(accountStatus);
                //--------------------------------------------------------------
                try {
                    autentikasi.setPassword(new PasswordUtil().encryptPassword(vo.getPassword()));
                } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
                    Logger.getLogger(AuthServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                //--------------------------------------------------------------
                if(CommonUtil.isNotNullOrEmpty(autentikasi)){
                    resultMap.put("authCode", authRepo.save(autentikasi).getCode());
                }
            } 
        }
        return resultMap;
    }
}
