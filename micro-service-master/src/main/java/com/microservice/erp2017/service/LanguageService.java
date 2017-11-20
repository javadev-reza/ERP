package com.microservice.erp2017.service;

import com.microservice.erp2017.model.vo.VO_M_Language;
import java.util.Map;

/**
 *
 * @author reza
 */
public interface LanguageService {
    Map save(VO_M_Language vo);
    Map update(VO_M_Language vo);
    Map delete(Integer primary);
}
