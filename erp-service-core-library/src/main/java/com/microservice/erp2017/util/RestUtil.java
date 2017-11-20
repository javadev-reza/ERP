package com.microservice.erp2017.util;

import com.microservice.erp2017.model.BaseTemp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author Reza
 */
public class RestUtil extends BaseTemp{
    
    private final Logger LOGGER = LoggerFactory.getLogger(RestUtil.class);
    
    public <T>ResponseEntity<T> getException (Exception e, HttpStatus status){
        e.printStackTrace();
        LOGGER.error("Got exception {} when saveMaster", e.getMessage());
        return new ResponseEntity<>(status);
    }

    public <T> ResponseEntity<T> getJsonResponse(T src) {
        HttpHeaders headers = new HttpHeaders();
	headers.set(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	return new ResponseEntity<>(src, headers, HttpStatus.OK);
    }

    public <T> ResponseEntity<T> getJsonResponse(T src, HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        Map<String,Object> map=new HashMap<>();
        map.put("data", src);
	return new ResponseEntity(map, headers, status);
    }

    public <T> ResponseEntity<T> getJsonResponse(T src,
        HttpStatus status, Map<String, String> mapHeaderMessage) {
        HttpHeaders headers = new HttpHeaders();
            if (null != mapHeaderMessage) {
                mapHeaderMessage.keySet().forEach((key) -> {
                    headers.add(key, mapHeaderMessage.get(key));
                });
            }
        Map<String,Object> map=new HashMap<>();
        map.put("messages", mapHeaderMessage);
        map.put("data", src);
        headers.set(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new ResponseEntity(map, headers, status);
    }
    
    public <T> ResponseEntity<T> getJsonResponse(HttpStatus status, Map<String, String> mapHeaderMessage) {
        HttpHeaders headers = new HttpHeaders();
            if (null != mapHeaderMessage) {
                mapHeaderMessage.keySet().forEach((key) -> {
                    headers.add(key, mapHeaderMessage.get(key));
                });
            }
        Map<String,Object> map=new HashMap<>();
        map.put("messages", mapHeaderMessage);
        headers.set(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new ResponseEntity(map, headers, status);
    }

    public <T> ResponseEntity<T> getJsonHttptatus(HttpStatus status) {
        return new ResponseEntity<>(status);
    }
	
    public <T> ResponseEntity<T> getJsonHttptatus(HttpStatus status, Map<String, String> mapHeaderMessage) {
        HttpHeaders headers = new HttpHeaders();
        if (null != mapHeaderMessage) {
            mapHeaderMessage.keySet().forEach((key) -> {
                headers.add(key, mapHeaderMessage.get(key));
            });
        }
        headers.set(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	return new ResponseEntity<>(headers, status);
    }
    
    public <T> ResponseEntity<Set<T>> defaultJsonResponse(Set<T> src) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	return new ResponseEntity<>(src, headers, HttpStatus.OK);
    }

    public <T> ResponseEntity<Set<T>> defaultJsonResponse(Set<T> src, Map<String, String> mapHeaderMessage) {
        HttpHeaders headers = new HttpHeaders();
	if (null != mapHeaderMessage) {
            mapHeaderMessage.keySet().forEach((key) -> {
                headers.add(key, mapHeaderMessage.get(key));
            });
	}
	headers.set(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	return new ResponseEntity<>(src, headers, HttpStatus.OK);
    }

    public <T> ResponseEntity<List<T>> defaultJsonResponse(List<T> src, Map<String, String> mapHeaderMessage) {
        HttpHeaders headers = new HttpHeaders();
	if (null != mapHeaderMessage) {
            mapHeaderMessage.keySet().forEach((key) -> {
                headers.add(key, mapHeaderMessage.get(key));
            });
	}
        headers.set(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return new ResponseEntity<>(src, headers, HttpStatus.OK);
    }

    public <T> ResponseEntity<List<T>> defaultJsonResponse(List<T> src) {
        HttpHeaders headers = new HttpHeaders();
	headers.set(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	return new ResponseEntity<>(src, headers, HttpStatus.OK);
    }

    public ResponseEntity<String> defaultJsonResponse(Object src) {
        Gson gson = new Gson();
        HttpHeaders headers = new HttpHeaders();
	headers.set(Header.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
	return new ResponseEntity<>(gson.toJson(src), headers, HttpStatus.OK);
    }
    
    public <T> T jsonToObject(String strJson, Class<T> type) {
        Gson gson = new Gson();
	return gson.fromJson(strJson, type);
    }

    public static String toJson(Object object) {
	Gson gson = new Gson();
	return gson.toJson(object);
    }
    
    public <T> ResponseEntity<T> setResponse200(Map result) {
        try{
            if(CommonUtil.isNotNullOrEmpty(result)){
                setMessage(MessageInfo.SUCCESS_MESSAGE, MessageResource.LABEL_SUCCESS);
                setResponse(getJsonResponse(result, HttpStatus.OK, getMessage()));
            } else{
                setMessage(MessageInfo.WARNING_MESSAGE, MessageResource.LABEL_NOT_FOUND);
                setResponse(getJsonResponse(HttpStatus.NOT_FOUND, getMessage()));
            }
        }catch(Exception e){
            getException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return getResponse();
    }
    
    public <T> ResponseEntity<T> setResponse200(List<Map> result) {
        try{
            if(CommonUtil.isNotNullOrEmpty(result)){
                setMessage(MessageInfo.SUCCESS_MESSAGE, MessageResource.LABEL_SUCCESS);
                setResponse(getJsonResponse(result, HttpStatus.OK, getMessage()));
            } else{
                setMessage(MessageInfo.WARNING_MESSAGE, MessageResource.LABEL_NOT_FOUND);
                setResponse(getJsonResponse(HttpStatus.NOT_FOUND, getMessage()));
            }
        }catch(Exception e){
            getException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return getResponse();
    }
    
    public PageRequest setPagination(int page, int size){
        return new PageRequest(page-1, size);
    }
    
}