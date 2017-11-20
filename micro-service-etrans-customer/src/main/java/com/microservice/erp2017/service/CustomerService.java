package com.microservice.erp2017.service;

import com.microservice.erp2017.model.BaseService;
import com.microservice.erp2017.model.T_Customer;
import com.microservice.erp2017.model.vo.VO_T_Customer;

/**
 *
 * @author Reza
 */
public interface CustomerService extends BaseService<VO_T_Customer, String>{
    T_Customer getOneByAuthCode(String authCode);
}
