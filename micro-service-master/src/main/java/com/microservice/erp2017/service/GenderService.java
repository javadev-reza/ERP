package com.microservice.erp2017.service;

import com.microservice.erp2017.model.vo.VO_M_Gender;
import java.util.Map;

/**
 *
 * @author reza
 */
public interface GenderService {
    Map save(VO_M_Gender vo);
    Map update(VO_M_Gender vo);
    Map delete(Integer primary);
}
