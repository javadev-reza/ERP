package com.microservice.erp2017.service;

import com.microservice.erp2017.model.vo.VO_M_Modul;
import java.util.Map;

/**
 *
 * @author reza
 */
public interface ModulService {
    Map save(VO_M_Modul vo);
    Map update(VO_M_Modul vo);
    Map delete(Integer primary);
}
