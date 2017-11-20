package com.microservice.erp2017.service;

import com.microservice.erp2017.model.vo.VO_M_District;
import java.util.Map;

/**
 *
 * @author reza
 */
public interface DistrictService {
    Map save(VO_M_District vo);
    Map update(VO_M_District vo);
    Map delete(Integer primary);
}
