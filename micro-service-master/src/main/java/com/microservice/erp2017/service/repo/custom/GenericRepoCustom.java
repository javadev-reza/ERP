package com.microservice.erp2017.service.repo.custom;

import java.util.List;
import java.util.Map;

/**
 *
 * @author reza
 */
public interface GenericRepoCustom {
    List<Map> getGenericModel(Integer rowStart, Integer size, String className, String fields, String criteria, String value);
    Integer getCountGenericModel(String className, String criteria, String value);
    Integer[] paging(Integer page, Integer size, Integer totalSize);
}
