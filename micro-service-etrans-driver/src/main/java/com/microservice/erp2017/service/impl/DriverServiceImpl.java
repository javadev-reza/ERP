package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.BaseServiceImpl;
import com.microservice.erp2017.model.T_DriverAddress;
import com.microservice.erp2017.model.T_Driver;
import com.microservice.erp2017.model.vo.VO_T_Driver;
import com.microservice.erp2017.model.vo.VO_T_DriverAddress;
import com.microservice.erp2017.service.DriverAddressService;
import com.microservice.erp2017.util.CommonUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.microservice.erp2017.service.DriverService;
import org.springframework.data.domain.Pageable;
import com.microservice.erp2017.service.repo.DriverRepo;

/**
 *
 * @author Reza
 */
@Service("DriverService")
public class DriverServiceImpl extends BaseServiceImpl implements DriverService{

    @Autowired 
    private DriverRepo driverRepo;
    
    @Autowired 
    private DriverAddressService driverAddressService;
    
    @Override
    public T_Driver getOneByAuthCode(String authCode){
        T_Driver resultData = driverRepo.getOneByAuthCode(authCode);
        if(CommonUtil.isNotNullOrEmpty(resultData)){
            return resultData; 
        } else{
            return null;
        }
    }
    
    @Override
    @Transactional(readOnly = false)
    public Map save(VO_T_Driver vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            
            T_Driver resultData = getOneByAuthCode(vo.getAuthCode());
            //------------------------------------------------------------------
            if(CommonUtil.isNullOrEmpty(resultData)){
                
                T_Driver driver = new T_Driver();
                //--------------------------------------------------------------
                BeanUtils.copyProperties(vo, driver);
                //--------------------------------------------------------------
                driver.setAuthCode(vo.getAuthCode());
                
                if(CommonUtil.isNotNullOrEmpty(driver)){
                    T_Driver driverResult = driverRepo.save(driver);

                    if(CommonUtil.isNotNullOrEmpty(driverResult)){
                        
                        if(CommonUtil.isNotNullOrEmpty(vo.getAddress())){
                            
                            VO_T_DriverAddress driverAddressVo = new VO_T_DriverAddress();
                            //--------------------------------------------------
                            BeanUtils.copyProperties(vo.getAddress(), driverAddressVo);
                            //--------------------------------------------------
                            driverAddressVo.setDriverCode(driverResult.getCode());
                            //--------------------------------------------------
                            driverAddressService.save(driverAddressVo);
                        }
                        resultMap.put("result", driverResult.getCode());
                    }
                }
            }
        }
        return resultMap;
    }

    @Override
    public Map update(VO_T_Driver vo) {
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
