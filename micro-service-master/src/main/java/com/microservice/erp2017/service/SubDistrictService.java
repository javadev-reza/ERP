package com.microservice.erp2017.service;

import com.microservice.erp2017.model.vo.VO_M_SubDistrict;
import java.util.Map;

/**
 *
 * @author reza
 */
public interface SubDistrictService {
    Map save(VO_M_SubDistrict vo);
    Map update(VO_M_SubDistrict vo);
    Map delete(Integer primary);
}
