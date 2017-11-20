package com.microservice.erp2017.service;

import com.microservice.erp2017.model.vo.VO_M_Label;
import java.util.Map;

/**
 *
 * @author reza
 */
public interface LabelService {
    Map save(VO_M_Label vo);
    Map update(VO_M_Label vo);
    Map delete(Integer primary);
}
