package com.microservice.erp2017.model;

import static com.microservice.erp2017.constant.WebConstant.MessageInfo.ACCOUNT_ERROR_MESSAGE;
import static com.microservice.erp2017.constant.WebConstant.MessageInfo.PASSWORD_ERROR_MESSAGE;
import static com.microservice.erp2017.constant.WebConstant.MessageInfo.USERNAME_ERROR_MESSAGE;
import com.microservice.erp2017.util.CommonUtil;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;

public abstract class BaseServiceImpl extends BaseConverter {
    
    private final Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);
    
    @SuppressWarnings("unchecked")
    public void setloginMessage(String errorUserName, String errorPassword, String accountStatus){
        Map<String, Object> errorResult = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(errorUserName)){
            errorResult.put(USERNAME_ERROR_MESSAGE, errorUserName);
        } else{
            errorResult.put(USERNAME_ERROR_MESSAGE, errorUserName);
        }
        if(CommonUtil.isNotNullOrEmpty(errorPassword)){
            errorResult.put(PASSWORD_ERROR_MESSAGE, errorPassword);
        } else{
            errorResult.put(PASSWORD_ERROR_MESSAGE, errorPassword);
        }
        if(CommonUtil.isNotNullOrEmpty(accountStatus)){
            errorResult.put(ACCOUNT_ERROR_MESSAGE, accountStatus);
        } else{
            errorResult.put(ACCOUNT_ERROR_MESSAGE, accountStatus);
        }
        super.setLoginMessage(errorResult);
    }
    
    @SuppressWarnings("unchecked")
    public void setloginMessage(String message, String value){
        Map<String, Object> errorResult = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(value)){
            errorResult.put(message, value);
        }
        super.setLoginMessage(errorResult);
    }
    
    public void getException (Exception e){
        e.printStackTrace();
        LOGGER.error("Got exception {} when saveMaster", e.getMessage());
    }
    
    public String getRefferalCode() {
        SecureRandom numberGenerator = null;
	final long MSB = 0x8000000000000000L;
        SecureRandom ng = numberGenerator;
	if (ng == null) {
            numberGenerator = ng = new SecureRandom();
	}
	return Long.toHexString(MSB | ng.nextLong()) + Long.toHexString(MSB | ng.nextLong());
    }
    
    public Page setResultPage(Page value){
        data = null;
        if(CommonUtil.isNotNullOrEmpty(value)){
            data = value;
        }
        return data;
    }
    
    public Map getResultPage(){
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(data)){
            resultMap.put("result", data.getContent());
            resultMap.put("totalPages", data.getTotalPages());
            resultMap.put("totalElements", data.getTotalElements());
        }
        return resultMap;
        
    }
    
    public String filterBy(String name){
        return "%"+name+"%";
    }
    
    public <T> T getClassModel(String clazz){
        return (T) clazz.getClass();
    }
}
