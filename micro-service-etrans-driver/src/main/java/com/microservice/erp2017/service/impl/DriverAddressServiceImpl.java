package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.T_DriverAddress;
import com.microservice.erp2017.model.vo.VO_T_DriverAddress;
import com.microservice.erp2017.service.DriverAddressService;
import com.microservice.erp2017.service.repo.DriverAddressRepo;
import com.microservice.erp2017.util.CommonUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author reza
 */
@Service("")
public class DriverAddressServiceImpl implements DriverAddressService{
    
    @Autowired 
    private DriverAddressRepo driverAddressRepo;

    @Override
    public Map save(VO_T_DriverAddress vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            T_DriverAddress address = new T_DriverAddress();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo.getAddress(), address);
            //------------------------------------------------------------------
           if(CommonUtil.isNotNullOrEmpty(address)){
                resultMap.put("result", driverAddressRepo.save(address).getCode());
            }
        }
        return resultMap;
    }

    @Override
    public Map update(VO_T_DriverAddress vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map delete(String primary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map getOne(String primary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map getAll(Pageable page, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
