package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.BaseServiceImpl;
import com.microservice.erp2017.model.T_Customer;
import com.microservice.erp2017.model.vo.VO_T_Customer;
import com.microservice.erp2017.service.CustomerService;
import com.microservice.erp2017.util.CommonUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.microservice.erp2017.service.repo.CustomerRepo;

/**
 *
 * @author Reza
 */
@Service("CustomerService")
public class CustomerServiceImpl extends BaseServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepo customerRepository;
    
    @Override
    public T_Customer getOneByAuthCode(String authCode){
        T_Customer resultData = customerRepository.getOneByAuthCode(authCode);
        if(CommonUtil.isNotNullOrEmpty(resultData)){
            return resultData; 
        } else{
            return null;
        }
    }
    
    @Override
    public Map save(VO_T_Customer vo) {
        Map<String, Object> resultMap = new HashMap<>();

        if(CommonUtil.isNotNullOrEmpty(vo)){
            
            if(CommonUtil.isNullOrEmpty(getOneByAuthCode(vo.getAuthCode()))){
                T_Customer customer = new T_Customer();
                BeanUtils.copyProperties(vo, customer);

                T_Customer customerResult = customerRepository.save(customer);
                if(CommonUtil.isNotNullOrEmpty(customerResult)){
                    resultMap.put("result", customerResult.getCode());
                }
            }
        }
        return resultMap;
    }

    @Override
    public Map update(VO_T_Customer vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            T_Customer customer = customerRepository.findOne(vo.getCode());
            BeanUtils.copyProperties(vo, customer);
            resultMap.put("result", customerRepository.save(customer).getCode());
        }
        return resultMap;
    }

    @Override
    public Map delete(String primary) {
         Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(primary)){
            T_Customer customer = customerRepository.findOne(primary);
            customer.setStatusEnabled(false);
            resultMap.put("result", customerRepository.save(customer).getCode());
        }
        return resultMap;
    }

    @Override
    public Map getOne(String primary) {
        return customerRepository.getOneByCode(primary);
    }

    @Override
    public Map getAll(Pageable page, String name) {
        return null;
    }
    
}
