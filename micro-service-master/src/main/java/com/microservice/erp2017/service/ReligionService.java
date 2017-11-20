package com.microservice.erp2017.service;

import com.microservice.erp2017.model.vo.VO_M_Religion;
import java.util.Map;

/**
 *
 * @author reza
 */
public interface ReligionService {
    Map save(VO_M_Religion vo);
    Map update(VO_M_Religion vo);
    Map delete(Integer primary);
}
