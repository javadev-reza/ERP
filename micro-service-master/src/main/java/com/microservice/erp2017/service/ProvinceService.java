package com.microservice.erp2017.service;

import com.microservice.erp2017.model.vo.VO_M_Province;
import java.util.Map;

/**
 *
 * @author reza
 */
public interface ProvinceService {
    Map save(VO_M_Province vo);
    Map update(VO_M_Province vo);
    Map delete(Integer primary);
}
