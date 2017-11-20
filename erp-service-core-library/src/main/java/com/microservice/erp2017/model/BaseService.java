package com.microservice.erp2017.model;

import java.util.Map;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Reza
 * @param <T>
 * @param <Object>
 */
public interface BaseService<T, Object>{
    Map save(T vo);
    Map update(T vo);
    Map delete(Object primary);
    Map getOne(Object primary);
    Map getAll(Pageable page, String name);
}
