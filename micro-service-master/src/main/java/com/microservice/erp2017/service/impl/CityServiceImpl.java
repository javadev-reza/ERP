package com.microservice.erp2017.service.impl;

import com.microservice.erp2017.model.M_City;
import com.microservice.erp2017.model.vo.VO_M_City;
import com.microservice.erp2017.service.CityService;
import com.microservice.erp2017.service.repo.CityRepo;
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
@Service("CityService")
public class CityServiceImpl implements CityService{
    
    @Autowired
    private CityRepo cityRepo;

    @Override
    public Map save(VO_M_City vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_City city = new M_City();
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, city);
            //------------------------------------------------------------------
            resultMap.put("result", cityRepo.save(city).getCity());
        }
        
        return resultMap;
    }

    @Override
    public Map update(VO_M_City vo) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(vo)){
            //------------------------------------------------------------------
            M_City city = cityRepo.findOne(vo.getId());
            //------------------------------------------------------------------
            BeanUtils.copyProperties(vo, city);
            //------------------------------------------------------------------
            resultMap.put("result", cityRepo.save(city).getCity());
        }
        
        return resultMap;
    }

    @Override
    public Map delete(Integer primary) {
        Map<String, Object> resultMap = new HashMap<>();
        
        if(CommonUtil.isNotNullOrEmpty(primary)){
            //------------------------------------------------------------------
            M_City city = cityRepo.findOne(primary);
            //------------------------------------------------------------------
            city.setStatusEnabled(false);
            //------------------------------------------------------------------
            resultMap.put("result", cityRepo.save(city).getCity());
        }
        
        return resultMap;
    }
    
}
