package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.T_CompanyAddress;
import com.microservice.erp2017.model.vo.VO_T_CompanyAddress;
import com.microservice.erp2017.service.CompanyAddressService;
import com.microservice.erp2017.service.repo.CompanyAddressRepo;
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
@Service("CompanyAddressService")
public class CompanyAddressServiceImpl implements CompanyAddressService{
    
    @Autowired
    private CompanyAddressRepo companyAddressRepo;

    @Override
    public Map save(VO_T_CompanyAddress vo) {
        Map<String, Object> resultMap = new HashMap<>();
        //------------------------------------------------------------------
        if(CommonUtil.isNotNullOrEmpty(vo)){
            
            T_CompanyAddress address = new T_CompanyAddress();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, address);
            //------------------------------------------------------------------
            if(CommonUtil.isNotNullOrEmpty(address)){
                resultMap.put("result", companyAddressRepo.save(address).getCode());
            }
        }
        return resultMap;
    }

    @Override
    public Map update(VO_T_CompanyAddress vo) {
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
