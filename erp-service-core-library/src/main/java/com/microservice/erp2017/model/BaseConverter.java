package com.microservice.erp2017.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class BaseConverter extends BaseTemp {

    @SuppressWarnings("unchecked")
	public <T> Object ToModel(Object instance, T clazz){
        return new Gson().fromJson(new Gson().toJson(instance), (Class<T>) clazz.getClass());
    }

    public <T> Map<String, Object> ToMap(T clazz){
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return new Gson().fromJson(new Gson().toJsonTree(clazz), type);
    }
    
    public <T> List<Map> ToListMap(List<T> listClazz){
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return new Gson().fromJson(new Gson().toJsonTree(listClazz), type);
    }
}
