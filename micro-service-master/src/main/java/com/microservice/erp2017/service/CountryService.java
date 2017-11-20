package com.microservice.erp2017.service;

import com.microservice.erp2017.model.vo.VO_M_Country;
import java.util.Map;

/**
 *
 * @author reza
 */
public interface CountryService {
    Map save(VO_M_Country vo);
    Map update(VO_M_Country vo);
    Map delete(Integer primary);
}
