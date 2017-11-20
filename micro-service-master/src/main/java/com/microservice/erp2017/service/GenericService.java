package com.microservice.erp2017.service;

import java.util.Map;

/**
 *
 * @author reza
 */
public interface GenericService {
    Map getAll(Integer page, Integer size, String className, String fields, String criteria, String value);
}
