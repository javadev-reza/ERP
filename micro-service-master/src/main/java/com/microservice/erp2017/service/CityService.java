package com.microservice.erp2017.service;

import com.microservice.erp2017.model.vo.VO_M_City;
import java.util.Map;

/**
 *
 * @author reza
 */
public interface CityService {
    Map save(VO_M_City vo);
    Map update(VO_M_City vo);
    Map delete(Integer primary);
}
