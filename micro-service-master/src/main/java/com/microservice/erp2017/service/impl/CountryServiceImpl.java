package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.M_Country;
import com.microservice.erp2017.model.vo.VO_M_Country;
import com.microservice.erp2017.service.CountryService;
import com.microservice.erp2017.service.repo.CountryRepo;
import com.microservice.erp2017.util.CommonUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author reza
 */
@Service("CountryService")
public class CountryServiceImpl implements CountryService{
    
    @Autowired
    private CountryRepo countryRepo;

    @Override
    public Map save(VO_M_Country vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Country country = new M_Country();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, country);
            //------------------------------------------------------------------
            resultMap.put("result", countryRepo.save(country).getCountry());
        }
        
        return resultMap;
    }

    @Override
    public Map update(VO_M_Country vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_Country country = countryRepo.findOne(vo.getId());
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, country);
            //------------------------------------------------------------------
            resultMap.put("result", countryRepo.save(country).getCountry());
        }
        
        return resultMap;
    }

    @Override
    public Map delete(Integer primary) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(primary)){
            //------------------------------------------------------------------
            M_Country country = countryRepo.findOne(primary);
            //------------------------------------------------------------------
            country.setStatusEnabled(false);
            //------------------------------------------------------------------
            resultMap.put("result", countryRepo.save(country).getCountry());
        }
        
        return resultMap;
    }
    
}
