package com.microservice.erp2017.service;

import com.microservice.erp2017.model.BaseService;
import com.microservice.erp2017.model.vo.VO_T_ModulToCompany;
import java.util.List;
import java.util.Map;

/**
 *
 * @author reza
 */
public interface ModulToCompanyService extends BaseService<VO_T_ModulToCompany, String>{
    List<Map<String, Object>> getModulByCompanyCode(String companyCode);
    List<Map<String, Object>> getApplicationByModulId(Integer modulId);
}
