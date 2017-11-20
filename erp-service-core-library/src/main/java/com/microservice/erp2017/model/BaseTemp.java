package com.microservice.erp2017.model;

import com.microservice.erp2017.constant.WebConstant;
import com.microservice.erp2017.util.CommonUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Reza
 * @param <Class>
 * @param <T>
 */
@SuppressWarnings("hiding")
public class BaseTemp<Class, T> extends WebConstant{
    
    protected Map<String, Object> message = new HashMap<>();
    protected Map<String, Object> loginMessage = new HashMap<>();
    protected ResponseEntity response;
    protected Page data = null;
    
    public void clearMessage(boolean isClear){
        if(isClear){
            message.clear();
        }
    }

    /**
     * @return the message
     */
    public Map getMessage() {
        return message;
    }

    /**
     * @param key
     * @param result
     */
    public void setMessage(String key, String result) {
        clearMessage(true);
        this.message.put(key, result);
    }
    
    public void clearLoginMessage(boolean isClear){
        if(isClear){
            loginMessage.clear();
        }
    }

    /**
     * @return the loginMessage
     */
    public Map<String, Object> getLoginMessage() {
        return loginMessage;
    }

    /**
     * @param loginMessage the loginMessage to set
     */
    public void setLoginMessage(Map<String, Object> loginMessage) {
        if(CommonUtil.isNotNullOrEmpty(loginMessage)){
            clearLoginMessage(true);
        }
        this.loginMessage = loginMessage;
    }

    /**
     * @return the response
     */
    public ResponseEntity getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(ResponseEntity response) {
        this.response = response;
    }

}