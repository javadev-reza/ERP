package com.microservice.erp2017.service;

import com.microservice.erp2017.model.vo.VO_M_Application;
import java.util.Map;

/**
 *
 * @author reza
 */
public interface ApplicationService {
    Map save(VO_M_Application vo);
    Map update(VO_M_Application vo);
    Map delete(Integer primary);
}
