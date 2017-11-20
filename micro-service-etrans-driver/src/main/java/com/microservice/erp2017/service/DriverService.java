package com.microservice.erp2017.service;

import com.microservice.erp2017.model.BaseService;
import com.microservice.erp2017.model.T_Driver;
import com.microservice.erp2017.model.vo.VO_T_Driver;

/**
 *
 * @author Reza
 */
public interface DriverService extends BaseService<VO_T_Driver, String>{
    T_Driver getOneByAuthCode(String authCode);
}
