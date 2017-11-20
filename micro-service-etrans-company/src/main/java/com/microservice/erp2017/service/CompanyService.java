package com.microservice.erp2017.service;

import com.microservice.erp2017.model.BaseService;
import com.microservice.erp2017.model.T_Company;
import com.microservice.erp2017.model.vo.VO_T_Company;

/**
 *
 * @author Reza
 */
public interface CompanyService extends BaseService<VO_T_Company, String>{
    T_Company getOneByAuthCode(String authCode);
}
